/**
 * Interface Strategy (EstrategiaRisco).
 *
 * Define a assinatura do método que todos os algoritmos
 * de cálculo de risco devem implementar.
 */
public interface EstrategiaRisco {
    
    void calcular(ContextoFinanceiro contexto);
}