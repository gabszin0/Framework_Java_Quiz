package framework.core;

import framework.excecoes.QuizException;
import framework.excecoes.RespostaInvalidaException;
import java.util.ArrayList;

public class Pergunta {

    private String enunciado;
    private ArrayList <String> alternativas;
    private int respostaCorreta;


    public Pergunta(String enunciado,ArrayList<String> alternativas, int respostaCorreta) {

        if (enunciado == null || enunciado.isBlank()) {
            throw new QuizException("O enunciado da pergunta não pode ser vazio.");
        }
        if (alternativas == null || alternativas.size() < 2) {
            throw new QuizException("A pergunta precisa ter ao menos duas alternativas.");
        }
        if (respostaCorreta < 1 || respostaCorreta > alternativas.size()) {
            throw new RespostaInvalidaException(
                    "Alternativa correta (" + respostaCorreta + ") fora do intervalo válido...");
        }

        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
        
    }

    
    public String getEnunciado() {
        return enunciado;
    }

    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setAlternativas(ArrayList<String> alternativas) {
        this.alternativas = alternativas;
    }

    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

}