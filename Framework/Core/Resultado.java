package framework.Core;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
    private int totalAcertos = 0;
    private int totalErros = 0;
    private int pontuacaoFinal = 0;
    private List<Resposta> respostas = new ArrayList<>();

    public void registrarResposta(Resposta resposta, int pontos) {
        respostas.add(resposta);
        if (resposta.isAcertou()) {
            totalAcertos++;
        } else {
            totalErros++;
        }
        pontuacaoFinal += pontos;
    }

    public int getTotalAcertos() { 
        return totalAcertos; 
    }

    public int getTotalErros() { 
        return totalErros; 
    }

    public int getPontuacaoFinal() { 
        return pontuacaoFinal; 
    }

}
