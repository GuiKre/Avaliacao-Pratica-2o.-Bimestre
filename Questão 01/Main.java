//Padrão: STRATEGY
// O Strategy foi escolhido para permitir que um ProcessadorRisco execute diferentes tipos de cálculos (VaR, ES, etc.), 
// delegando a lógica para objetos de "estratégia" separados. 
// O problema exigia que esses algoritmos pudessem ser trocados dinamicamente (em tempo real) pelo cliente. 
// Dessa forma, o processador central não precisa ser modificado para adicionar novos métodos de cálculo no futuro.
public class Main {

    public static void main(String[] args) {
        ContextoFinanceiro contexto = new ContextoFinanceiro(1000000.00, 0.15, 0.05);

        ProcessadorRisco processador = new ProcessadorRisco();

        processador.definirEstrategia(new EstrategiaVaR());
        processador.executarAnaliseRisco(contexto);

        processador.definirEstrategia(new EstrategiaES());
        processador.executarAnaliseRisco(contexto);

        processador.definirEstrategia(new EstrategiaStressTest());
        processador.executarAnaliseRisco(contexto);
    }
}