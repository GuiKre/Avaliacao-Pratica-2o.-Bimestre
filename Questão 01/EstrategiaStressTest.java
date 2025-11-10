/**
 * Estratégia Concreta 3: Stress Testing (Teste de Estresse).
 */
public class EstrategiaStressTest implements EstrategiaRisco {

    @Override
    public void calcular(ContextoFinanceiro contexto) {
        System.out.println("--- CÁLCULO Stress Testing ---");
        System.out.printf("Simulando cenários extremos (ex: crise de 2008) para o portfólio de R$ %.2f.\n",
            contexto.getValorPortfolio());
        System.out.println("Resultado: Portfólio resiliente a choques de mercado.\n");
    }
}