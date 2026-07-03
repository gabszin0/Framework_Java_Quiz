package framework.excecoes;

public class RespostaInvalidaException extends QuizException {
    public RespostaInvalidaException(String mensagem) {
        super(mensagem);
    }
}