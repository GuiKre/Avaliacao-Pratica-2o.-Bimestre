public class EstadoAlertaVermelho extends EstadoBase {
    public EstadoAlertaVermelho(UsinaNuclear usina) {
        super(usina);
        System.err.println("### PERIGO IMINENTE: ALERTA VERMELHO ATIVADO ###");
    }

    @Override
    public void aumentarPotencia(double quantidade) {
        System.err.println("### COMANDO IGNORADO: Impossível aumentar potência em ALERTA VERMELHO ###");
    }

    @Override
    public void verificarCondicoes() {
        if (!usina.isSistemaResfriamentoOK()) {
            System.err.println("### CATASTROFE: SISTEMA DE RESFRIAMENTO FALHOU! ###");
            usina.mudarEstado(new EstadoEmergencia(usina));
        }
    }
}