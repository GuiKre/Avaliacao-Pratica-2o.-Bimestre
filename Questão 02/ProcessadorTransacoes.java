/**
 * Interface que o cliente
 * deseja utilizar. É simples, tipada e usa objetos de resposta claros.
 */
public interface ProcessadorTransacoes {
    
    RespostaAutorizacao autorizar(String cartao, double valor, String moeda);
}