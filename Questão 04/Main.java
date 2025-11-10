//Padrão: Chain of Responsability
// valida um DocumentoFiscal passando-o por uma cadeia de objetos IValidador, 
// onde cada um foca em uma regra (XML, impostos, etc.). 
// Chain of Responsability foi escolhido pois o problema exigia uma série de validações em sequência. 
// O padrão permite que cada regra seja uma classe separada e que um orquestrador gerencie a execução da cadeia, 
// facilitando a implementação de regras como rollbacks e circuit breakers.
public class Main {

    public static void main(String[] args) {
        
        System.out.println("\n======= CENÁRIO 1: SUCESSO =======");
        CadeiaValidadores cadeiaSucesso = criarCadeia(false, false, false, 200);
        DocumentoFiscal docSucesso = new DocumentoFiscal("100", "<NF-e>...</NF-e>", 150.0);
        ResultadoValidacao resSucesso = cadeiaSucesso.executar(docSucesso);
        System.out.println(resSucesso);

        System.out.println("\n======= CENÁRIO 2: FALHA COM ROLLBACK =======");
        CadeiaValidadores cadeiaRollback = criarCadeia(false, false, true, 200); // Sefaz falha
        DocumentoFiscal docRollback = new DocumentoFiscal("200", "<NF-e>...</NF-e>", 150.0);
        ResultadoValidacao resRollback = cadeiaRollback.executar(docRollback);
        System.out.println(resRollback);

        System.out.println("\n======= CENÁRIO 3: CIRCUIT BREAKER =======");
        CadeiaValidadores cadeiaBreaker = criarCadeia(true, true, true, 200); // 3 falhas
        DocumentoFiscal docBreaker = new DocumentoFiscal("300", "XML_INVALIDO", -10); // Força 2 falhas
        docBreaker.setCertificado("EXPIRADO"); // Força 3a falha
        ResultadoValidacao resBreaker = cadeiaBreaker.executar(docBreaker);
        System.out.println(resBreaker);
        
        System.out.println("\n======= CENÁRIO 4: FALHA POR TIMEOUT =======");
        CadeiaValidadores cadeiaTimeout = criarCadeia(false, false, false, 500); // Sefaz demora 500ms
        DocumentoFiscal docTimeout = new DocumentoFiscal("400", "<NF-e>...</NF-e>", 150.0);
        ResultadoValidacao resTimeout = cadeiaTimeout.executar(docTimeout);
        System.out.println(resTimeout);
    }
    
    private static CadeiaValidadores criarCadeia(boolean falhaXml, boolean falhaCert, boolean falhaSefaz, int demoraSefaz) {
        CadeiaValidadores cadeia = new CadeiaValidadores();
        
        cadeia.adicionar(new ValidadorSchemaXML());
        
        cadeia.adicionar(new ValidadorCertificado());
        
        cadeia.adicionar(new ValidadorRegrasFiscais());
        
        cadeia.adicionar(new ValidadorDatabase(false));
        
        cadeia.adicionar(new ValidadorSefaz(falhaSefaz, demoraSefaz));
        
        return cadeia;
    }
}