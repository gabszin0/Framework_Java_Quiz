package framework.interfaces;

import framework.core.Resultado;
import java.util.ArrayList;

public interface TelaPresentacao {
    void exibirAlternativas(ArrayList<String> alternativas);
    void exibirPergunta(String p);
    void exibirResultadoPergunta(int p);
    void exibirResultadoFinal(Resultado r);

    int capturarResposta();

    void exibirFeedback(String mensagem);

}