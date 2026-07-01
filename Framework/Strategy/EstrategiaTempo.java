class EstrategiaComTempo implements EstrategiaPontuacao {

    public int calcularPontos(boolean acertou, int tempo) {
        if (!acertou) return 0;
        return 10 - (tempo / 10); // Bônus 
    }

}