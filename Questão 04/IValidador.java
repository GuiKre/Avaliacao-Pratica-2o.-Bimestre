/**
 * HANDLER.
 * Define o contrato para todos os elos da cadeia.
 */
public interface IValidador {

    void validar(DocumentoFiscal doc, ResultadoValidacao res);

    void desfazer(DocumentoFiscal doc);

    int getTimeoutMillis();

    boolean pararSeFalhar();
}