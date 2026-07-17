package framework.Cliente;
import framework.core.*;
import framework.interfaces.TelaPresentacao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

 public class TelaQuizSwing extends JFrame implements TelaPresentacao {

    private JLabel pergunta;
    ArrayList<JButton> botoes;


    public TelaQuizSwing(Pergunta perguntas) {
        setTitle("Quiz");
        setSize(500,300);

        exibirPergunta(perguntas.getEnunciado());
        exibirAlternativas(perguntas.getAlternativas());
    exibirResultadoPergunta(perguntas.getRespostaCorreta());







        setVisible(true);



    }
   public void exibirPergunta(String p){
       pergunta = new JLabel(p);
       pergunta.setHorizontalAlignment(SwingConstants.CENTER);
       pergunta.setFont(new Font("Arial", Font.BOLD, 18));
       add(pergunta, BorderLayout.NORTH);

   }
   public void exibirAlternativas(ArrayList<String> alternativas){
       JPanel painelAlternativas = new JPanel();
       painelAlternativas.setLayout(new GridLayout(4,1,10,10));
       botoes = new ArrayList<>();
       for(String alternativa:alternativas){
           botoes.add(new JButton(alternativa));

       }
        for(JButton botao:botoes){
            painelAlternativas.add(botao);
        }

       add(painelAlternativas, BorderLayout.CENTER);
        }





   public void exibirResultadoPergunta(int r){
       for(int i = 0; i < botoes.size(); i++) {

           JButton botao = botoes.get(i);

           int resposta = i; // guarda a posição do botão

           botao.addActionListener(e -> {

               if (resposta+1 == r) {
                   new TelaResultado("Resposta correta!");
               } else {
                   new TelaResultado("Resposta errada!");
               }

           });
       }
     }

     public int capturarResposta(){
            return 0;
     }

     public void exibirFeedback(String mensagem){

     }
   public void exibirResultadoFinal(Resultado r){

    }

}
class TelaResultado extends JFrame {

    public TelaResultado(String mensagem){

        setTitle("Resultado");
        setSize(300,150);

        JLabel texto = new JLabel(mensagem);
        texto.setHorizontalAlignment(SwingConstants.CENTER);

        add(texto);

        setVisible(true);
    }
}