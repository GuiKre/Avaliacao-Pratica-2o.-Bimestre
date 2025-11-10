/**
 * Validador Concreto 4.
 * Verifica duplicidade no banco de dados e "reserva" o número.
 */
public class ValidadorDatabase implements IValidador {
    
    private boolean falhaProposital = false;
    public ValidadorDatabase(boolean falha) { this.falhaProposital = falha; }
    
    @Override
    public void validar(DocumentoFiscal doc, ResultadoValidacao res) {
        SimuladorTrabalho.simular(80);
        
        if (this.falhaProposital) {
            res.adicionarErro("Database: Erro de conexão simulado.");
            return;
        }
        
        System.out.println("(DB) Inserindo reserva para nota: " + doc.getNumeroNota());
        doc.setDadoTemporario("RESERVA_DB_" + doc.getNumeroNota(), "PENDENTE");
    }
    
    @Override
    public void desfazer(DocumentoFiscal doc) {
        System.out.println("(DB) Rollback: Removendo reserva da nota: " + doc.getNumeroNota());
        doc.removerDadoTemporario("RESERVA_DB_" + doc.getNumeroNota());
    }
    
    @Override
    public int getTimeoutMillis() {
        return 150;
    }
    
    @Override
    public boolean pararSeFalhar() {
        return true;
    }
}