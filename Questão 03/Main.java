//Padrão: State
// O código gerencia uma UsinaNuclear cujo comportamento e regras mudam drasticamente dependendo da sua situação. 
// O padrão State foi escolhido para encapsular a lógica complexa de cada estado e suas regras de transição em classes separadas.
// Isso evita um método central com um if/else ou switch na classe UsinaNuclear, 
// tornando o código limpo e fácil de estender.
public class Main {

    public static void main(String[] args) {
        
        UsinaNuclear usina = new UsinaNuclear();
        
        System.out.println("--- SIMULAÇÃO 1: LIGAR E ALERTA AMARELO ---");
        usina.ligar();
        usina.aumentarPotencia(60.0);
        usina.simularVerificacao();
        
        System.out.println("\n--- SIMULAÇÃO 2: ALERTA VERMELHO (Regra #2) ---");
        usina.aumentarPotencia(100.0);
        usina.simularVerificacao();
        usina.aumentarPotencia(100.0);
        
        System.out.println("...Simulando 30 segundos em > 400°C...");
        for(int i = 0; i <= 30; i++) {
            usina.simularVerificacao();
        }
        
        System.out.println("\n--- SIMULAÇÃO 3: EMERGÊNCIA (Regra #3) ---");
        usina.aumentarPotencia(100);
        usina.setSistemaResfriamentoOK(false);
        usina.simularVerificacao();
        
        System.out.println("\n--- SIMULAÇÃO 4: TENTANDO AGIR EM EMERGÊNCIA ---");
        usina.ligar();
        usina.aumentarPotencia(100);
        usina.desligar();

        System.out.println("\n--- SIMULAÇÃO 5: MANUTENÇÃO (Req #5) ---");
        UsinaNuclear usina2 = new UsinaNuclear();
        usina2.iniciarManutencao();
        usina2.ligar();
        usina2.aumentarPotencia(100);
        usina2.sairManutencao();
        usina2.ligar();
    }
}