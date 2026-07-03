package framework.excecoes;

public class PerguntasNaoCarregadasException extends QuizException {
    public PerguntasNaoCarregadasException(String mensagem) {
        super(mensagem);
    }
}