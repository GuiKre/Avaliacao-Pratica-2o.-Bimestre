public class EstadoEmergencia extends EstadoBase {
    public EstadoEmergencia(UsinaNuclear usina) {
        super(usina);
        System.err.println("####### EMERGÊNCIA NUCLEAR - EVACUAR IMEDIATAMENTE #######");
    }
}