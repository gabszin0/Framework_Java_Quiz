package framework.Excecoes;

public class QuizException extends RuntimeException {
    public QuizException(String mensagem) {
        super(mensagem);
    }
}