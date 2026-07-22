package aplicacao1.cliente;

import framework.core.Pergunta;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> alternativas = new ArrayList<>();
        alternativas.add("imprimeF();");
        alternativas.add("postf();");
        alternativas.add("printf();");
        alternativas.add("System.out.println()");
        Pergunta p = new Pergunta("Qual é o comando para imprimir dados em C? ",alternativas,3); // a resposta correta aqui é a posição da alternativa
        new TelaQuizSwing(p);                                                                                               // se é a primeira,segunda ou quarta alternativa
    }
    
}
