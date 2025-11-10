/**
 * Estratégia Concreta 2: Expected Shortfall (ES).
 */
public class EstrategiaES implements EstrategiaRisco {

    @Override
    public void calcular(ContextoFinanceiro contexto) {
        System.out.println("--- CÁLCULO ES (Expected Shortfall) ---");
        System.out.printf("Calculando ES (além do VaR) para o portfólio de R$ %.2f.\n",
            contexto.getValorPortfolio());
        System.out.println("Resultado: Risco de perda média de 8% nos piores cenários.\n");
    }
}