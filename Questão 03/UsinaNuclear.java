/**
 * CLASSE DE CONTEXTO.
 *
 * A UsinaNuclear mantém uma referência ao seu estado ATUAL.
 * Ela não conhece a lógica específica de CADA estado.
 * Ela delega o comportamento para o objeto de estado atual.
 */
public class UsinaNuclear {

    private EstadoUsina estadoAtual;

    private double temperaturaReator = 250.0;
    private boolean sistemaResfriamentoOK = true;
    private int tempoEmAlertaAmareloSeg = 0;

    public UsinaNuclear() {
        this.estadoAtual = new EstadoDesligada(this);
    }

    public void mudarEstado(EstadoUsina novoEstado) {
        System.out.printf("\n--- TRANSIÇÃO DE ESTADO: %s -> %s ---\n",
                estadoAtual.getClass().getSimpleName(),
                novoEstado.getClass().getSimpleName());
        this.estadoAtual = novoEstado;
    }

    public void ligar() {
        estadoAtual.ligar();
    }

    public void desligar() {
        estadoAtual.desligar();
    }

    public void aumentarPotencia(double quantidade) {
        estadoAtual.aumentarPotencia(quantidade);
    }

    public void iniciarManutencao() {
        estadoAtual.iniciarManutencao();
    }
    
    public void sairManutencao() {
        estadoAtual.sairManutencao();
    }

    public void simularVerificacao() {
        System.out.println("[Usina] Verificando condições...");
        estadoAtual.verificarCondicoes();
    }

    public double getTemperaturaReator() {
        return temperaturaReator;
    }

    public void setTemperaturaReator(double temperaturaReator) {
        this.temperaturaReator = temperaturaReator;
        System.out.printf("[Usina] Temperatura atualizada: %.1f°C\n", temperaturaReator);
    }

    public boolean isSistemaResfriamentoOK() {
        return sistemaResfriamentoOK;
    }

    public void setSistemaResfriamentoOK(boolean sistemaResfriamentoOK) {
        this.sistemaResfriamentoOK = sistemaResfriamentoOK;
        System.out.println("[Usina] Sistema de resfriamento OK: " + sistemaResfriamentoOK);

    }

    public int getTempoEmAlertaAmareloSeg() {
        return tempoEmAlertaAmareloSeg;
    }

    public void setTempoEmAlertaAmareloSeg(int tempoEmAlertaAmareloSeg) {
        this.tempoEmAlertaAmareloSeg = tempoEmAlertaAmareloSeg;
    }
}