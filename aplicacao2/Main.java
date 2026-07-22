package aplicacao2;

import framework.interfaces.TelaPresentacao;
import framework.interfaces.EstrategiaPontuacao;
import framework.strategy.EstrategiaSimples;
import framework.core.Pergunta; 
import framework.core.Quiz; 
import framework.factory.QuizFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Bem-vindo ao Quiz de Matemática");

        ArrayList<String> alt1 = new ArrayList<>(Arrays.asList(
            "2", 
            "10", 
            "0", 
            "200"
        ));
        Pergunta p1 = new Pergunta("Quanto é 1+1", alt1, 1);


        ArrayList<String> alt2 = new ArrayList<>(Arrays.asList(
            "20000", 
            "2", 
            "0", 
            "25"
        ));
        Pergunta p2 = new Pergunta("Qual é a raiz de 4?", alt2, 2); 


        ArrayList<String> alt3 = new ArrayList<>(Arrays.asList(
            "93", 
            "raiz 3/2", 
            "0", 
            "1/2"
        ));
        Pergunta p3 = new Pergunta("Quanto é o Seno de 30°", alt3, 3); 

    
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        perguntas.add(p1);
        perguntas.add(p2);
        perguntas.add(p3);


        TelaPresentacao tela = new ExibicaoConsole();
        EstrategiaPontuacao estrategia = new EstrategiaSimples();

        
        Quiz quizDeCorrida = QuizFactory.criar(tela, estrategia);


        quizDeCorrida.executar(); 
    }
}
