package framework.core;

public class Resposta {

    private Pergunta pergunta;
    private int alternativaEscolhida;
    private int tempoDecorridoEmSegundos;
    private boolean acertou;

    public Resposta(Pergunta pergunta, int alternativaEscolhida, int tempoDecorrido, boolean acertou) {
        this.pergunta = pergunta;
        this.alternativaEscolhida = alternativaEscolhida;
        this.tempoDecorridoEmSegundos = tempoDecorrido;
        this.acertou = acertou;
    }

    public boolean isAcertou() { 
        return acertou; 
    }
    
    public int getTempoDecorridoEmSegundos() { 
        return tempoDecorridoEmSegundos; 
    }

}
