package Framework.Interface;

interface TelaPresentacao {

    void exibirPergunta(Pergunta p);

    void exibirResultado(Resultado r);

    int capturarResposta();

    void exibirFeedback(String mensagem);

}