package aplicacao1;

import framework.core.Quiz;
import framework.factory.QuizFactory;
import framework.interfaces.EstrategiaPontuacao;
import framework.interfaces.TelaPresentacao;
import framework.strategy.EstrategiaSimples;

public class Main {
    public static void main(String[] args) {
        TelaPresentacao tela = new TelaQuizSwing();
        EstrategiaPontuacao estrategia = new EstrategiaSimples();

        QuizFactory factory = new QuizProgFactory();
        Quiz quiz = factory.criarQuiz(tela, estrategia);

        new Thread(quiz::executar, "quiz-thread").start();
    } 
}
