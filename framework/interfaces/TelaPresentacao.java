package framework.interfaces;

import framework.core.Pergunta;
import framework.core.Resultado;

public interface TelaPresentacao {

    void exibirPergunta(Pergunta p);

    void exibirResultado(Resultado r);

    int capturarResposta();

    void exibirFeedback(String mensagem);

}