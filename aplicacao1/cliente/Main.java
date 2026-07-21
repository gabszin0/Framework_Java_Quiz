package aplicacao1.cliente;

import framework.core.Pergunta;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> alternativas = new ArrayList<>();
        alternativas.add("1");
        alternativas.add("2");
        alternativas.add("3");
        alternativas.add("4");
        Pergunta p = new Pergunta("Quanto é 1+1",alternativas,2); // a resposta correta aqui é a posição da alternativa
        new TelaQuizSwing(p);                                                                // se é a primeira,segunda ou quarta alternativa
    }
}
