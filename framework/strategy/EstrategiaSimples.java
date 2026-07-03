package framework.strategy;

import framework.interfaces.EstrategiaPontuacao;

public class EstrategiaSimples implements EstrategiaPontuacao {
    
    @Override
    public int calcularPontos(boolean acertou, int tempo) {
        return acertou ? 10 : 0;
    }

}