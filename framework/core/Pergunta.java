package framework.core;

import java.util.ArrayList;

public class Pergunta {

    private String enunciado;
    private ArrayList <String> alternativas;
    private int respostaCorreta;


    public Pergunta(String enunciado,ArrayList<String> alternativas, int respostaCorreta) {
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