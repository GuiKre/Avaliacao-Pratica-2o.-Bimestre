/**
 * Um DTO simples que representa a resposta
 * no formato moderno que o cliente espera.
 */
public class RespostaAutorizacao {
    private final boolean aprovada;
    private final String idTransacao;
    private final String mensagem;

    public RespostaAutorizacao(boolean aprovada, String idTransacao, String mensagem) {
        this.aprovada = aprovada;
        this.idTransacao = idTransacao;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "RespostaAutorizacao {\n" +
                "  aprovada=" + aprovada + ",\n" +
                "  idTransacao='" + idTransacao + "',\n" +
                "  mensagem='" + mensagem + "'\n" +
                '}';
    }
}