# Framework_Java_Quiz
 
Framework Java orientado a objetos para desenvolvimento de aplicações do tipo *quiz*, com desacoplamento total entre lógica de execução, cálculo de pontuação e interface de apresentação.
 
## Visão geral
 
O núcleo do framework (pacote `framework`) define o fluxo comum a qualquer quiz, deixando para as aplicações concretas apenas a responsabilidade de fornecer as perguntas e a interface visual. Duas aplicações de exemplo demonstram essa reutilização: um **Quiz de Programação** (interface gráfica Swing) e um **Quiz de Matemática** (interface via console).
 
## Arquitetura e padrões de projeto
 
| Padrão | Onde é aplicado | Papel |
|---|---|---|
| **Template Method** | `Quiz.executar()` | Define o algoritmo fixo do quiz (inicializar → percorrer perguntas → finalizar), delegando `carregarPerguntas()` às subclasses (`QuizProg`, `QuizMat`). |
| **Strategy** | `EstrategiaPontuacao` | Encapsula regras de pontuação intercambiáveis: `EstrategiaSimples`, `EstrategiaComPenalidade` e `EstrategiaTempo` (bônus por velocidade). |
| **Factory Method** | `QuizFactory` | `criarQuiz()` delega a `construirQuiz()` a construção do `Quiz` concreto, isolando o cliente da classe instanciada (`QuizProgFactory`, `QuizMatFactory`). |
 
A interface `TelaPresentacao` desacopla completamente a apresentação: o núcleo do framework não conhece Swing nem console, apenas o contrato (`exibirPergunta`, `capturarResposta`, `exibirResultadoFinal` etc.). Isso permite plugar qualquer UI sem alterar `Quiz`.
 
## Estrutura de pacotes
 
```
framework/
 ├─ core/        Quiz (abstrato), Pergunta, Resposta, Resultado
 ├─ interfaces/  EstrategiaPontuacao, TelaPresentacao
 ├─ strategy/    Implementações de EstrategiaPontuacao
 ├─ factory/     QuizFactory (abstrato)
 └─ excecoes/    Hierarquia de exceções (QuizException e subclasses)
aplicacao1/      Quiz de Programação — UI Swing (TelaQuizSwing)
aplicacao2/      Quiz de Matemática — UI console (ExibicaoConsole)
```
 
## Tratamento de exceções
 
Todas as exceções específicas do domínio estendem `QuizException` (RuntimeException): `PerguntasNaoCarregadasException`, `RespostaInvalidaException`, `ErroCarregamentoDadosException`, `EstrategiaNotConfiguredException` e `InterfaceNaoConfiguradaException`. A validação ocorre na origem — por exemplo, `Pergunta` recusa enunciados vazios ou índice de resposta correta fora do intervalo de alternativas.
 
## Concorrência na UI Swing
 
Em `TelaQuizSwing`, `capturarResposta()` bloqueia a thread do quiz (executada em uma `Thread` separada) até que o usuário clique em uma alternativa, usando uma `SynchronousQueue<Integer>` para sincronizar com a Event Dispatch Thread (EDT). Isso mantém a EDT sempre responsiva, sem travar a interface enquanto se aguarda a resposta.
 
## Extensibilidade
 
Uma nova aplicação-quiz exige apenas: (1) subclasse de `Quiz` implementando `carregarPerguntas()`; (2) uma `QuizFactory` correspondente; (3) opcionalmente, uma nova implementação de `TelaPresentacao` ou reuso de uma existente. Nenhuma classe do núcleo precisa ser modificada — aderência ao princípio Open/Closed.
 
