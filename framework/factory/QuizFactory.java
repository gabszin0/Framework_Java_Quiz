package framework.factory;

import framework.core.Quiz;
import framework.interfaces.EstrategiaPontuacao;
import framework.interfaces.TelaPresentacao;

public abstract class QuizFactory {

    public final Quiz criarQuiz(TelaPresentacao tela, EstrategiaPontuacao estrategia) {
        return construirQuiz(tela, estrategia);
    }

    protected abstract Quiz construirQuiz(TelaPresentacao tela, EstrategiaPontuacao estrategia);
}