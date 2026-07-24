package aplicacao2;

import framework.core.Quiz;
import framework.factory.QuizFactory;
import framework.interfaces.EstrategiaPontuacao;
import framework.interfaces.TelaPresentacao;
import framework.strategy.EstrategiaSimples;


public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Quiz de Matematica");

        TelaPresentacao tela = new ExibicaoConsole();
        EstrategiaPontuacao estrategia = new EstrategiaSimples();

        QuizFactory factory = new QuizMatFactory();
        Quiz quiz = factory.criarQuiz(tela, estrategia);

        quiz.executar();
    }
}
