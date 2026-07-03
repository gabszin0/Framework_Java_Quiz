package framework.core;

public class Quiz implements EstrategiaPontuacao, TelaPresentacao {
    protected TelaPresentacao tela;
    protected EstrategiaPontuacao estrategia;
    protected Resultado resultado;

    public Quiz(TelaPresentacao tela, EstrategiaPontuacao estrategia) {
        this.tela = tela;
        this.estrategia = estrategia;
        this.resultado = new Resultado();
    }

    // TEMPLATE METHOD:
    public final void executar() {
        inicializar();
        while (temPerguntas()) {
            processarPerguntaAtual();
            avancarProxima();
        }
        finalizarQuiz();
    }

    // Métodos que as aplicações específicas vão ter que implementar
    protected abstract void inicializar();
    protected abstract boolean temPerguntas();
    protected abstract void processarPerguntaAtual();
    protected abstract void avancarProxima();
    

    protected void finalizarQuiz() {
        tela.exibirResultado(resultado);
    }

}
