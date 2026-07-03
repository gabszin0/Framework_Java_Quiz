package framework.strategy;

import framework.interfaces.EstrategiaPontuacao;

class EstrategiaComPenalidade implements EstrategiaPontuacao {

    @Override
    public int calcularPontos(boolean acertou, int tempo) {
        return acertou ? 10 : -5;
    }
    
}