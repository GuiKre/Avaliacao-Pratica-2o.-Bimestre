/**
 * Validador Concreto 2.
 * Verifica a validade do certificado digital.
 */
public class ValidadorCertificado implements IValidador {
    @Override
    public void validar(DocumentoFiscal doc, ResultadoValidacao res) {
        SimuladorTrabalho.simular(150);
        if (!doc.getCertificado().equals("CERTIFICADO_VALIDO")) {
            res.adicionarErro("Certificado: Certificado expirado ou revogado.");
        }
    }

    @Override
    public void desfazer(DocumentoFiscal doc) {}

    @Override
    public int getTimeoutMillis() {
        return 200;
    }

    @Override
    public boolean pararSeFalhar() {
        return true;
    }
}