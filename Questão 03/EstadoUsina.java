/**
 * INTERFACE STATE.
 *
 * Define todas as ações possíveis que podem ser executadas na usina.
 * Cada estado concreto implementará estas ações de forma diferente.
 */
public interface EstadoUsina {

    void ligar();
    void desligar();
    void aumentarPotencia(double quantidade);
    void iniciarManutencao();
    void sairManutencao();

    void verificarCondicoes();
}