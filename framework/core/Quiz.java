package framework.core;

import framework.excecoes.PerguntasNaoCarregadasException;
import framework.interfaces.EstrategiaPontuacao;
import framework.interfaces.TelaPresentacao;
import java.util.List;

public abstract class Quiz {
    protected final TelaPresentacao tela;
    protected final EstrategiaPontuacao estrategia;
    protected Resultado resultado;
    protected List<Pergunta> perguntas;
    private int indiceAtual;

    public Quiz(TelaPresentacao tela, EstrategiaPontuacao estrategia) {
        this.tela = tela;
        this.estrategia = estrategia;
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

    protected void inicializar() {
        this.perguntas = carregarPerguntas();
        if (perguntas == null || perguntas.isEmpty()) {
            throw new PerguntasNaoCarregadasException(
                    "carregarPerguntas() não retornou nenhuma pergunta para " + getClass().getSimpleName());
        }
        this.resultado = new Resultado();
        this.indiceAtual = 0;
    }

    protected void processarPerguntaAtual() {
        Pergunta perguntaAtual = perguntas.get(indiceAtual);

        tela.exibirPergunta(perguntaAtual.getEnunciado());
        tela.exibirAlternativas(perguntaAtual.getAlternativas());

        long inicio = System.currentTimeMillis();
        int respostaEscolhida = tela.capturarResposta();
        int tempoDecorrido = (int) ((System.currentTimeMillis() - inicio) / 1000);

        boolean acertou = respostaEscolhida == perguntaAtual.getRespostaCorreta();
        int pontos = estrategia.calcularPontos(acertou, tempoDecorrido);

        resultado.registrarResposta(
                new Resposta(perguntaAtual, respostaEscolhida, tempoDecorrido, acertou), pontos);

        tela.exibirResultadoPergunta(pontos);
    }

    protected boolean temPerguntas() {
        return indiceAtual < perguntas.size();
    }

    protected void avancarProxima() {
        indiceAtual++;
    }

    protected void finalizarQuiz() {
        tela.exibirResultadoFinal(resultado);
    }

    protected abstract List<Pergunta> carregarPerguntas();

}
