/**
 * Validador Concreto 5.
 * Simula a consulta online no serviço da SEFAZ.
 */
public class ValidadorSefaz implements IValidador {
    
    private boolean falhaProposital = false;
    private int demoraSimuladaMs = 200;
    
    public ValidadorSefaz(boolean falha, int demoraMs) {
         this.falhaProposital = falha;
         this.demoraSimuladaMs = demoraMs;
    }

    @Override
    public void validar(DocumentoFiscal doc, ResultadoValidacao res) {
        SimuladorTrabalho.simular(this.demoraSimuladaMs);
        if (this.falhaProposital) {
            res.adicionarErro("Sefaz: Serviço indisponível (Erro 503).");
        }
    }

    @Override
    public void desfazer(DocumentoFiscal doc) {}

    @Override
    public int getTimeoutMillis() {
        return 300;
    }

    @Override
    public boolean pararSeFalhar() {
        return true;
    }
}