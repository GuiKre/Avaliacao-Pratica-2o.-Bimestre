/**
 * Validador Concreto 1.
 * Verifica o schema XML básico.
 */
public class ValidadorSchemaXML implements IValidador {
    @Override
    public void validar(DocumentoFiscal doc, ResultadoValidacao res) {
        SimuladorTrabalho.simular(50);
        if (!doc.getXmlConteudo().startsWith("<NF-e>")) {
            res.adicionarErro("XML: Conteúdo não é uma NF-e válida.");
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