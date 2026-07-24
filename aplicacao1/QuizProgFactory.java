package aplicacao1;

import framework.core.Quiz;
import framework.factory.QuizFactory;
import framework.interfaces.EstrategiaPontuacao;
import framework.interfaces.TelaPresentacao;

public class QuizProgFactory extends QuizFactory {

    @Override
    protected Quiz construirQuiz(TelaPresentacao tela, EstrategiaPontuacao estrategia) {
        return new QuizProg(tela, estrategia);
    }

}
