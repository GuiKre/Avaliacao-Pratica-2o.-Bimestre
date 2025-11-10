public class EstadoManutencao extends EstadoBase {
    public EstadoManutencao(UsinaNuclear usina) {
        super(usina);
        System.out.println("[Usina] Entrando em modo de MANUTENÇÃO. Operações normais suspensas.");
    }

    @Override
    public void aumentarPotencia(double quantidade) {
        System.out.println("[Manutenção] Comando 'Aumentar Potência' ignorado.");
    }

    @Override
    public void ligar() {
         System.out.println("[Manutenção] A usina já está em manutenção, não pode ser ligada.");
    }
    
    @Override
    public void sairManutencao() {
        System.out.println("[Usina] Saindo do modo de manutenção.");
        usina.mudarEstado(new EstadoDesligada(usina));
    }
}