/**
 * Estratégia Concreta 1: Value at Risk (VaR).
 */
public class EstrategiaVaR implements EstrategiaRisco {

    @Override
    public void calcular(ContextoFinanceiro contexto) {
        // Cálculo dummy (simulado)
        System.out.println("--- CÁLCULO VaR (Value at Risk) ---");
        System.out.printf("Calculando VaR para um portfólio de R$ %.2f com volatilidade de %.2f%%.\n",
                contexto.getValorPortfolio(), contexto.getVolatilidade() * 100);
        System.out.println("Resultado: Risco de 5% de perda.\n");
    }
}