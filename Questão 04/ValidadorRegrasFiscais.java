/**
 * Validador Concreto 3.
 * Verifica as regras de negócio.
 */
public class ValidadorRegrasFiscais implements IValidador {
    @Override
    public void validar(DocumentoFiscal doc, ResultadoValidacao res) {
        SimuladorTrabalho.simular(20);
        if (doc.getValorImpostoCalculado() <= 0) {
            res.adicionarErro("Fiscal: Cálculo de impostos está zerado ou negativo.");
        }
    }

    @Override
    public void desfazer(DocumentoFiscal doc) {}

    @Override
    public int getTimeoutMillis() {
        return 100;
    }

    @Override
    public boolean pararSeFalhar() {
        return true;
    }
}