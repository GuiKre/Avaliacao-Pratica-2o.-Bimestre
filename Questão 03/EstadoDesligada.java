public class EstadoDesligada extends EstadoBase {
    public EstadoDesligada(UsinaNuclear usina) {
        super(usina);
    }

    @Override
    public void ligar() {
        System.out.println("Ligando a usina...");
        usina.setTemperaturaReator(250.0);
        usina.mudarEstado(new EstadoOperacaoNormal(usina));
    }

    @Override
    public void iniciarManutencao() {
        usina.mudarEstado(new EstadoManutencao(usina));
    }
}