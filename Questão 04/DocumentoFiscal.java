import java.util.HashMap;
import java.util.Map;

/**
 * Objeto de dados que será passado pela cadeia.
 */
public class DocumentoFiscal {
    private String xmlConteudo;
    private String certificado;
    private double valorImpostoCalculado;
    private String numeroNota;
    
    private Map<String, Object> dados = new HashMap<>();

    public DocumentoFiscal(String numeroNota, String xml, double imposto) {
        this.numeroNota = numeroNota;
        this.xmlConteudo = xml;
        this.valorImpostoCalculado = imposto;
        this.certificado = "CERTIFICADO_VALIDO";
    }

    public String getXmlConteudo() { return xmlConteudo; }
    public String getCertificado() { return certificado; }
    public double getValorImpostoCalculado() { return valorImpostoCalculado; }
    public String getNumeroNota() { return numeroNota; }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }


    public void setDadoTemporario(String chave, Object valor) {
        System.out.printf("[Documento] Modificado: %s = %s\n", chave, valor);
        this.dados.put(chave, valor);
    }
    
    public void removerDadoTemporario(String chave) {
         System.out.printf("[Documento] Desfeito: %s removido\n", chave);
         this.dados.remove(chave);
    }
}