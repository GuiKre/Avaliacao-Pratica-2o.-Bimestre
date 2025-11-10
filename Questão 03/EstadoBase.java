public abstract class EstadoBase implements EstadoUsina {
    protected UsinaNuclear usina;

    public EstadoBase(UsinaNuclear usina) {
        this.usina = usina;
    }

    @Override
    public void ligar() {
        System.out.println("Ação 'Ligar' inválida para o estado atual.");
    }
    @Override
    public void desligar() {
        System.out.println("Ação 'Desligar' inválida para o estado atual.");
    }
    @Override
    public void aumentarPotencia(double quantidade) {
        System.out.println("Ação 'Aumentar Potência' inválida para o estado atual.");
    }
    @Override
    public void iniciarManutencao() {
        System.out.println("Ação 'Iniciar Manutenção' inválida para o estado atual.");
    }
    @Override
    public void sairManutencao() {
        System.out.println("Ação 'Sair da Manutenção' inválida para o estado atual.");
    }
    
    @Override
    public void verificarCondicoes() {}
}