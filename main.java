import aplicacao1.QuizProgFactory;
import aplicacao1.TelaQuizSwing;
import aplicacao2.ExibicaoConsole;
import aplicacao2.QuizMatFactory;
import framework.core.Quiz;
import framework.factory.QuizFactory;
import framework.interfaces.EstrategiaPontuacao;
import framework.interfaces.TelaPresentacao;
import framework.strategy.EstrategiaSimples;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
             opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1 -> executarQuizProgramacao();
                case 2 -> executarQuizMatematica(scanner);
                case 0 -> System.out.println("Encerrando.");
                default -> System.out.println("Opcao invalida.");
            }
        }while(opcao!=0);
        }

    private static int lerOpcao(Scanner scanner) {
        System.out.println("=== Framework_Java_Quiz ===");
        System.out.println("1 - Quiz de Programacao (interface grafica - Swing)");
        System.out.println("2 - Quiz de Matematica (console)");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");

        if (!scanner.hasNextLine()) {
            return 0;
        }
        String linha = scanner.nextLine().trim();

        try {
            return Integer.parseInt(linha);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void executarQuizProgramacao() {
        TelaPresentacao tela = new TelaQuizSwing();
        EstrategiaPontuacao estrategia = new EstrategiaSimples();

        QuizFactory factory = new QuizProgFactory();
        Quiz quiz = factory.criarQuiz(tela, estrategia);

        new Thread(quiz::executar, "quiz-thread").start();
    }

    private static void executarQuizMatematica(Scanner scanner) {
        System.out.println("Bem-vindo ao Quiz de Matematica");

        TelaPresentacao tela = new ExibicaoConsole(scanner);
        EstrategiaPontuacao estrategia = new EstrategiaSimples();

        QuizFactory factory = new QuizMatFactory();
        Quiz quiz = factory.criarQuiz(tela, estrategia);

        quiz.executar();
    }
}