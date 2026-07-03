package framework.Excecoes;

public class PerguntasNaoCarregadasException extends QuizException {
    public PerguntasNaoCarregadasException(String mensagem) {
        super(mensagem);
    }
}