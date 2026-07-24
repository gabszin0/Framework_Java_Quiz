package aplicacao1; 

import framework.core.Resultado;
import framework.interfaces.TelaPresentacao;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import javax.swing.*;

public class TelaQuizSwing extends JFrame implements TelaPresentacao {

    private final JLabel labelPergunta = new JLabel("", SwingConstants.CENTER);
    private final JPanel painelCentral = new JPanel();
    private final JLabel labelFeedback = new JLabel(" ", SwingConstants.CENTER);
    private final SynchronousQueue<Integer> filaResposta = new SynchronousQueue<>();

    public TelaQuizSwing() {
        setTitle("Quiz de Programação");
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        labelPergunta.setFont(new Font("Arial", Font.BOLD, 18));
        add(labelPergunta, BorderLayout.NORTH);
        add(painelCentral, BorderLayout.CENTER);
        add(labelFeedback, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void exibirPergunta(String enunciado) {
        SwingUtilities.invokeLater(() -> {
            labelPergunta.setText(enunciado);
            labelFeedback.setText(" ");
        });
    }

    @Override
    public void exibirAlternativas(ArrayList<String> alternativas) {
        runNaEdtEEsperar(() -> {
            painelCentral.removeAll();
            painelCentral.setLayout(new GridLayout(alternativas.size(), 1, 8, 8));
            for (int i = 0; i < alternativas.size(); i++) {
                int alternativaEscolhida = i + 1; // 1-based, igual ao resto do framework
                JButton botao = new JButton(alternativas.get(i));
                botao.addActionListener(e -> {
                    try {
                        filaResposta.put(alternativaEscolhida);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                });
                painelCentral.add(botao);
            }
            painelCentral.revalidate();
            painelCentral.repaint();
        });
    }

    @Override
    public int capturarResposta() {
        try {
            return filaResposta.take(); // bloqueia a thread do QUIZ, nunca a EDT
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }

    @Override
    public void exibirResultadoPergunta(int pontosGanhos) {
        SwingUtilities.invokeLater(() ->
                labelFeedback.setText((pontosGanhos >= 0 ? "+" : "") + pontosGanhos + " pontos"));
    }

    @Override
    public void exibirResultadoFinal(Resultado resultado) {
        SwingUtilities.invokeLater(() -> {
            painelCentral.removeAll();
            painelCentral.setLayout(new BorderLayout());
            String mensagem = "<html><center>Fim do quiz!<br>"
                    + "Acertos: " + resultado.getTotalAcertos() + "<br>"
                    + "Erros: " + resultado.getTotalErros() + "<br>"
                    + "Pontuação final: " + resultado.getPontuacaoFinal()
                    + "</center></html>";
            labelPergunta.setText("Resultado");
            labelFeedback.setText(" ");
            painelCentral.add(new JLabel(mensagem, SwingConstants.CENTER), BorderLayout.CENTER);
            painelCentral.revalidate();
            painelCentral.repaint();
        });
    }

    @Override
    public void exibirFeedback(String mensagem) {
        SwingUtilities.invokeLater(() -> labelFeedback.setText(mensagem));
    }

    /** Executa r na EDT e espera terminar antes de devolver o controle à thread do quiz. */
    private void runNaEdtEEsperar(Runnable r) {
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        } else {
            try {
                SwingUtilities.invokeAndWait(r);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } catch (java.lang.reflect.InvocationTargetException e) {
                throw new RuntimeException(e.getCause() != null ? e.getCause() : e);
            }
        }
    }
}