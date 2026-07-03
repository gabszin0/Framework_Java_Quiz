package framework.Strategy;

class EstrategiaComPenalidade implements EstrategiaPontuacao {

    public int calcularPontos(boolean acertou, int tempo) {
        return acertou ? 10 : -5;
    }
    
}