package aplicacao2;

import framework.core.Resultado;
import framework.interfaces.TelaPresentacao;
import java.util.ArrayList;
import java.util.Scanner;

public class ExibicaoConsole implements TelaPresentacao { 
    
    private Scanner scanner;

    public ExibicaoConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void exibirPergunta(String p) {
        System.out.println("\n=======================================");
        System.out.println("PERGUNTA: " + p);
    }

    @Override
    public void exibirAlternativas(ArrayList<String> alternativas) {
        System.out.println("---------------------------------------");
        for (int i = 0; i < alternativas.size(); i++) {
            // Supondo que a alternativa 1 seja o índice 0 da lista
            System.out.println((i + 1) + ") " + alternativas.get(i));
        }
        System.out.println("=======================================");
    }

    @Override
    public int capturarResposta() {
        System.out.print("Digite o número da resposta e aperte ENTER: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ops! Digite apenas o número.");
            return -1; 
        }
    }

    @Override
    public void exibirResultadoPergunta(int p) {
        System.out.println("Pontos nessa rodada: " + p);
    }

    @Override
    public void exibirResultadoFinal(Resultado r) {
        System.out.println("\n FIM DE JOGO! 🏁");
        System.out.println("Acertos: " + r.getTotalAcertos());
        System.out.println("Erros: " + r.getTotalErros());
        System.out.println("Pontuação Total: " + r.getPontuacaoFinal());

    }

    @Override
    public void exibirFeedback(String mensagem) {
        System.out.println("Feedback: " + mensagem);
    }

}