public class EstadoOperacaoNormal extends EstadoBase {
    public EstadoOperacaoNormal(UsinaNuclear usina) {
        super(usina);
        usina.setTempoEmAlertaAmareloSeg(0);
    }

    @Override
    public void aumentarPotencia(double quantidade) {
        System.out.println("Aumentando potência...");
        usina.setTemperaturaReator(usina.getTemperaturaReator() + quantidade);
    }

    @Override
    public void desligar() {
        System.out.println("Iniciando procedimento de desligamento...");
        usina.setTemperaturaReator(50.0);
        usina.mudarEstado(new EstadoDesligada(usina));
    }

    @Override
    public void verificarCondicoes() {
        if (usina.getTemperaturaReator() > 300) {
            System.err.println("ALERTA: Temperatura > 300°C!");
            usina.mudarEstado(new EstadoAlertaAmarelo(usina));
        }
    }
}