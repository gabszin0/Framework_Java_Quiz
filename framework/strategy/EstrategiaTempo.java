package framework.strategy;

import framework.interfaces.EstrategiaPontuacao;

public class EstrategiaTempo implements EstrategiaPontuacao {

    @Override
    public int calcularPontos(boolean acertou, int tempo) {
        if (!acertou) return 0;
        return 10 - (tempo / 10); // Bônus 
    }

}