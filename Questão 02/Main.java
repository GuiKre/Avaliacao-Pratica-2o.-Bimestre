//Padrão: Adapter
// O padrão Adapter foi escolhido para permitir que o sistema cliente, que usa a interface moderna ProcessadorTransacoes, 
// consiga se comunicar com o SistemaBancarioLegado, que possui uma interface incompatível (baseada em HashMap). 
// Sua função é "traduzir" chamadas e respostas entre duas interfaces que não foram projetadas para funcionar juntas. 
// Unindo os dois sistemas sem precisar modificar o código-fonte de nenhum deles.
public class Main {

    public static void main(String[] args) {
        
        SistemaBancarioLegado sistemaLegado = new SistemaBancarioLegado();

        ProcessadorTransacoes meuProcessador = new AdaptadorTransacao(sistemaLegado);

        System.out.println("--- Executando Transação 1 (BRL) ---");
        RespostaAutorizacao resp1 = meuProcessador.autorizar("1234-5678-9012-3456", 150.75, "BRL");
        System.out.println("\n[Cliente] Resposta recebida:\n" + resp1);
        
        System.out.println("\n--- Executando Transação 2 (USD) ---");
        RespostaAutorizacao resp2 = meuProcessador.autorizar("9876-5432-1098-7654", 99.99, "USD");
        System.out.println("\n[Cliente] Resposta recebida:\n" + resp2);

        System.out.println("\n--- Executando Transação 3 (Falha Moeda) ---");
        RespostaAutorizacao resp3 = meuProcessador.autorizar("1111-2222-3333-4444", 50.00, "JPY");
        System.out.println("\n[Cliente] Resposta recebida:\n" + resp3);
    }
}