package framework.factory;

import framework.core.Quiz;
import framework.interfaces.EstrategiaPontuacao;
import framework.interfaces.TelaPresentacao;

public interface QuizFactory {

    Quiz criar(TelaPresentacao tela, EstrategiaPontuacao estrategia);
    
}