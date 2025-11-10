import java.util.HashMap;
import java.util.UUID;

/**
 * Classe do sistema legado:
 * - Recebe um HashMap genérico, em vez de parâmetros tipados.
 * - Retorna um HashMap genérico.
 * - Espera códigos numéricos para moedas.
 * - Espera um campo "COD_SEGURANCA" que o sistema novo não tem.
 */
public class SistemaBancarioLegado {

    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        System.out.println("[Legado] Recebendo transação...");
        
        if (!parametros.containsKey("CARTAO_NUM") || !parametros.containsKey("VALOR_TOTAL")) {
            return criarRespostaLegada(500, "ERRO_PARAMETROS", null);
        }

        if (!parametros.containsKey("COD_SEGURANCA_LOJA")) {
            System.err.println("[Legado] FALHA: Campo obrigatório 'COD_SEGURANCA_LOJA' não fornecido.");
            return criarRespostaLegada(501, "FALHA_SEGURANCA", null);
        }
        
        Integer codMoeda = (Integer) parametros.get("COD_MOEDA");
        if (codMoeda != 1 && codMoeda != 2 && codMoeda != 3) {
             System.err.println("[Legado] FALHA: Código de moeda inválido: " + codMoeda);
            return criarRespostaLegada(502, "MOEDA_INVALIDA", null);
        }

        System.out.println("[Legado] Transação Aprovada para o cartão: " + parametros.get("CARTAO_NUM"));
        System.out.println("[Legado] Valor: " + parametros.get("VALOR_TOTAL"));
        System.out.println("[Legado] Moeda (Código): " + codMoeda);
        System.out.println("[Legado] Cód. Segurança Loja: " + parametros.get("COD_SEGURANCA_LOJA"));


        String idTransacao = UUID.randomUUID().toString();
        return criarRespostaLegada(200, "APROVADA", idTransacao);
    }

    private HashMap<String, Object> criarRespostaLegada(int status, String msg, String txId) {
        HashMap<String, Object> resposta = new HashMap<>();
        resposta.put("STATUS_CODE", status);
        resposta.put("MSG", msg);
        if (txId != null) {
            resposta.put("ID_TX", txId);
        }
        return resposta;
    }
}