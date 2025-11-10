import java.util.ArrayList;
import java.util.List;

/**
 * Coleta os resultados da validação.
 */
public class ResultadoValidacao {
    private List<String> erros = new ArrayList<>();
    private int contagemErrosNaEntrada = 0; 

    public void adicionarErro(String erro) {
        this.erros.add(erro);
    }

    public boolean temFalhas() {
        return !erros.isEmpty();
    }
    
    public void marcarInicioValidacao() {
        this.contagemErrosNaEntrada = erros.size();
    }
    
    public boolean ultimoValidadorFalhou() {
        return erros.size() > this.contagemErrosNaEntrada;
    }

    @Override
    public String toString() {
        if (!temFalhas()) {
            return "VALIDAÇÃO BEM SUCEDIDA.";
        }
        StringBuilder sb = new StringBuilder("FALHA NA VALIDAÇÃO:\n");
        for (String erro : erros) {
            sb.append("- ").append(erro).append("\n");
        }
        return sb.toString();
    }
}