/**
 * Classe utilitária para simular latência (trabalho ou I/O de rede)
 * e testar os requisitos de timeout.
 */
public class SimuladorTrabalho {
    public static void simular(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}