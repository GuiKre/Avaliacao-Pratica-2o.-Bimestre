import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ORQUESTRADOR.
 *
 * gerencia a lista de handlers e
 * implementa a lógica de Circuit Breaker, Rollback e Timeouts.
 */
public class CadeiaValidadores {

    private List<IValidador> validadores = new ArrayList<>();
    
    private Deque<IValidador> historicoModificacao = new ArrayDeque<>();
    
    private int contadorFalhas = 0;
    private final int LIMITE_FALHAS_CIRCUIT_BREAKER = 3;

    public void adicionar(IValidador validador) {
        this.validadores.add(validador);
    }

    public ResultadoValidacao executar(DocumentoFiscal doc) {
        ResultadoValidacao res = new ResultadoValidacao();
        this.contadorFalhas = 0;
        this.historicoModificacao.clear();
        System.out.println("--- INICIANDO CADEIA DE VALIDAÇÃO ---");

        for (IValidador validador : validadores) {
            System.out.println("Executando: " + validador.getClass().getSimpleName());
            
            res.marcarInicioValidacao();
            
            long startTime = System.nanoTime();
            
            validador.validar(doc, res);
            
            long durationMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            if (durationMs > validador.getTimeoutMillis()) {
                res.adicionarErro(validador.getClass().getSimpleName() + ": EXCEDEU TIMEOUT de " + validador.getTimeoutMillis() + "ms (levou " + durationMs + "ms)");
            }

            if (res.ultimoValidadorFalhou()) {
                this.contadorFalhas++;
                System.err.println("-> FALHA detectada. Contagem de falhas: " + this.contadorFalhas);

                if (this.contadorFalhas >= LIMITE_FALHAS_CIRCUIT_BREAKER) {
                    res.adicionarErro("CIRCUIT BREAKER ATIVADO: A cadeia foi interrompida após " + this.contadorFalhas + " falhas.");
                    break;
                }
                
                if (validador.pararSeFalhar()) {
                    System.err.println("-> Validador CRÍTICO falhou. Interrompendo a cadeia.");
                    break;
                }
            } else {
                if (validador instanceof ValidadorDatabase) {
                    this.historicoModificacao.push(validador);
                }
            }
        }

        if (res.temFalhas()) {
            System.err.println("--- EXECUTANDO ROLLBACK ---");
            while (!this.historicoModificacao.isEmpty()) {
                IValidador v = this.historicoModificacao.pop();
                System.out.println("Desfazendo: " + v.getClass().getSimpleName());
                v.desfazer(doc);
            }
        }
        
        System.out.println("--- FIM DA VALIDAÇÃO ---");
        return res;
    }
}