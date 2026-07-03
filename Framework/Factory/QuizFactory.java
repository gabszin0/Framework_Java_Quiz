package framework.Factory;

public class QuizFactory {

    static Quiz criar(String tipo) {
        switch (tipo) {
            case "programacao":
                return new QuizProgramacao();
            case "matemática":
                return new QuizMatematica();
            case "conhecimentos gerais":
                return new QuizGeral();
            default:
                throw new IllegalArgumentException("Tipo de quiz inválido: " + tipo);
        }
    }
    
}