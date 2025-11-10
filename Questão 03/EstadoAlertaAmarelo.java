public class EstadoAlertaAmarelo extends EstadoBase {
    public EstadoAlertaAmarelo(UsinaNuclear usina) {
        super(usina);
    }
    
    @Override
    public void aumentarPotencia(double quantidade) {
        System.err.println("AVISO: Aumentando potência em ALERTA AMARELO. Perigoso.");
        usina.setTemperaturaReator(usina.getTemperaturaReator() + (quantidade * 0.5));
    }

    @Override
    public void verificarCondicoes() {
        if (usina.getTemperaturaReator() <= 300) {
            System.out.println("INFO: Temperatura estabilizada. Voltando à operação normal.");
            usina.mudarEstado(new EstadoOperacaoNormal(usina));
            return;
        }

        if (usina.getTemperaturaReator() > 400) {
            int tempo = usina.getTempoEmAlertaAmareloSeg() + 1;
            usina.setTempoEmAlertaAmareloSeg(tempo);
            System.err.printf("ALERTA: Temp > 400°C por %d segundos.\n", tempo);
            
            if (tempo > 30) {
                System.err.println("PERIGO: Limite de 30s excedido!");
                usina.mudarEstado(new EstadoAlertaVermelho(usina));
            }
        } else {
            usina.setTempoEmAlertaAmareloSeg(0);
        }
    }
}