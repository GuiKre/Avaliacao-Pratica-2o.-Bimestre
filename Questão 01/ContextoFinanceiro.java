/**
 * Representa o "contexto complexo com múltiplos parâmetros financeiros"
 * que será compartilhado com todas as estratégias de cálculo.
 */
public class ContextoFinanceiro {
    private double valorPortfolio;
    private double volatilidade;
    private double taxaJuros;

    public ContextoFinanceiro(double valorPortfolio, double volatilidade, double taxaJuros) {
        this.valorPortfolio = valorPortfolio;
        this.volatilidade = volatilidade;
        this.taxaJuros = taxaJuros;
    }

    public double getValorPortfolio() {
        return valorPortfolio;
    }

    public double getVolatilidade() {
        return volatilidade;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }
}