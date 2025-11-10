/**
 * Classe de Contexto (Context).
 * Esta classe utiliza um objeto EstrategiaRisco para realizar o cálculo.
 * Ela não sabe qual algoritmo específico está sendo usado.
 */
public class ProcessadorRisco {

    private EstrategiaRisco estrategia;

    public void definirEstrategia(EstrategiaRisco estrategia) {
        System.out.println("[ProcessadorRisco]: Alterando estratégia de cálculo...");
        this.estrategia = estrategia;
    }

    public void executarAnaliseRisco(ContextoFinanceiro contexto) {
        if (estrategia == null) {
            System.err.println("Erro: Nenhuma estratégia de risco foi definida.");
            return;
        }

        this.estrategia.calcular(contexto);
    }
}