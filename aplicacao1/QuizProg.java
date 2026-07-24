package aplicacao1;

import framework.core.Pergunta;
import framework.core.Quiz;
import framework.interfaces.EstrategiaPontuacao;
import framework.interfaces.TelaPresentacao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizProg extends Quiz{
    
    public QuizProg(TelaPresentacao tela, EstrategiaPontuacao estrategia) {
        super(tela, estrategia);
    }

    @Override
    protected List<Pergunta> carregarPerguntas() {
        List<Pergunta> listaPerguntas = new ArrayList<>();

        listaPerguntas.add(new Pergunta(
                "Qual é o comando para imprimir dados em C?",
                new ArrayList<>(Arrays.asList("imprimeF();", "postf();", "printf();", "System.out.println()")),
                3));

        listaPerguntas.add(new Pergunta(
                "Em Java, qual palavra-chave cria uma nova instância de um objeto?",
                new ArrayList<>(Arrays.asList("new", "create", "instance", "make")),
                1));

        listaPerguntas.add(new Pergunta(
                "Qual estrutura de repetição garante ao menos uma execução do bloco?",
                new ArrayList<>(Arrays.asList("for", "while", "do-while", "if")),
                3));

        return listaPerguntas;
    }
}
