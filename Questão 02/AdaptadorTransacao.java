import java.util.HashMap;

/**
 * ADAPTER.
 *
 * Faz a ponte entre a
 * interface moderna (ProcessadorTransacoes) e o sistema legado
 * (SistemaBancarioLegado).
 */
public class AdaptadorTransacao implements ProcessadorTransacoes {

    private final SistemaBancarioLegado legado;

    private final String CODIGO_LOJA_PADRAO = "LOJA_CENTRAL_001";

    public AdaptadorTransacao(SistemaBancarioLegado legado) {
        this.legado = legado;
    }

    @Override
    public RespostaAutorizacao autorizar(String cartao, double valor, String moeda) {
        System.out.println("[Adaptador] Recebida requisição moderna. Traduzindo para o legado...");

        HashMap<String, Object> parametrosLegado = new HashMap<>();
        parametrosLegado.put("CARTAO_NUM", cartao);
        parametrosLegado.put("VALOR_TOTAL", valor);
        
        parametrosLegado.put("COD_MOEDA", converterMoedaParaCodigo(moeda));

        parametrosLegado.put("COD_SEGURANCA_LOJA", this.CODIGO_LOJA_PADRAO);
        
        HashMap<String, Object> respostaLegada = this.legado.processarTransacao(parametrosLegado);
        
        System.out.println("[Adaptador] Recebida resposta legada. Traduzindo para o moderno...");
        return converterRespostaLegada(respostaLegada);
    }

    private int converterMoedaParaCodigo(String moeda) {
        switch (moeda.toUpperCase()) {
            case "USD": return 1;
            case "EUR": return 2;
            case "BRL": return 3;
            default: return 0;
        }
    }

    private RespostaAutorizacao converterRespostaLegada(HashMap<String, Object> respostaLegada) {
        boolean aprovada = (Integer) respostaLegada.get("STATUS_CODE") == 200;
        
        String idTransacao = (String) respostaLegada.getOrDefault("ID_TX", null);
        
        String mensagem = (String) respostaLegada.get("MSG");

        return new RespostaAutorizacao(aprovada, idTransacao, mensagem);
    }
}