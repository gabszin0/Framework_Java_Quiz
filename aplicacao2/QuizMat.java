package aplicacao2;

import framework.core.Pergunta;
import framework.core.Quiz;
import framework.interfaces.EstrategiaPontuacao;
import framework.interfaces.TelaPresentacao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizMat extends Quiz {
    
    public QuizMat(TelaPresentacao tela, EstrategiaPontuacao estrategia) {
        super(tela, estrategia);
    }

    @Override
    protected List<Pergunta> carregarPerguntas() {
        List<Pergunta> listaPerguntas = new ArrayList<>();

        listaPerguntas.add(new Pergunta("Quanto e 1 + 1?",
                new ArrayList<>(Arrays.asList("2", "10", "0", "200")), 1));

        listaPerguntas.add(new Pergunta("Qual e a raiz quadrada de 4?",
                new ArrayList<>(Arrays.asList("20000", "2", "0", "25")), 2));

        listaPerguntas.add(new Pergunta("Quanto e o seno de 30?",
                new ArrayList<>(Arrays.asList("93", "raiz de 3/2", "0", "1/2")), 4));

        return listaPerguntas;
    }

}
