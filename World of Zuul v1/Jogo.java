/**
 * Essa eh a classe principal da aplicacao "World of Zull".
 * "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.
 * Usuarios podem caminhar em um cenario. E eh tudo! Ele realmente
 * precisa ser estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 * "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os
 * ambientes, cria o analisador e comeca o jogo. Ela tambeme avalia e
 * executa os comandos que o analisador retorna.
 * 
 * @author Michael Kölling and David J. Barnes (traduzido por Julio Cesar Alves)
 * @version 2011.07.31 (2016.02.01)
 */

public class Jogo {
    private Analisador analisador;
    private Ambiente ambienteAtual;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        criarAmbientes();
        analisador = new Analisador();
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente fora, corredor, adega, dormitorio, banheiro2, salaJogos, banheiro1, armazem, salaReunioes, salaArmas, garagem, refeitorio, salaTreinamento;

        // cria os ambientes
        fora = new Ambiente("fora da base da mafia");
        corredor = new Ambiente("no corredor da base da mafia");
        adega = new Ambiente("no adega");
        dormitorio = new Ambiente("no dormitorio");
        banheiro2 = new Ambiente("no banheiro");
        salaJogos = new Ambiente("na sala de jogos");
        banheiro1 = new Ambiente("no banheiro");
        armazem = new Ambiente("no armazem");
        salaReunioes = new Ambiente("na sala de reunioes");
        salaArmas = new Ambiente ("na sala de armas");
        garagem = new Ambiente ("na sala de armas");
        refeitorio = new Ambiente ("no refeitorio");
        salaTreinamento = new Ambiente ("na sala de treinamento");


        corredor.ajustarSaidas("norte", salaJogos);
        corredor.ajustarSaidas("leste", dormitorio);
        corredor.ajustarSaidas("sul", adega);
        corredor.ajustarSaidas("oeste", banheiro2);
        corredor.ajustarSaidas("noroeste",null);
        corredor.ajustarSaidas("sudeste",null);

        adega.ajustarSaidas("norte", corredor);
        adega.ajustarSaidas("leste", armazem);
        adega.ajustarSaidas("sul", null);
        adega.ajustarSaidas("oeste", null);
        adega.ajustarSaidas("noroeste",null);
        adega.ajustarSaidas("sudeste",null);

        dormitorio.ajustarSaidas("norte", null);
        dormitorio.ajustarSaidas("leste", salaTreinamento);
        dormitorio.ajustarSaidas("sul", null);
        dormitorio.ajustarSaidas("oeste", corredor);
        dormitorio.ajustarSaidas("noroeste",null);
        dormitorio.ajustarSaidas("sudeste",null);

        banheiro2.ajustarSaidas("norte", null);
        banheiro2.ajustarSaidas("leste", corredor);
        banheiro2.ajustarSaidas("sul", null);
        banheiro2.ajustarSaidas("oeste", null);
        banheiro2.ajustarSaidas("noroeste",null);
        banheiro2.ajustarSaidas("sudeste",null);

        salaJogos.ajustarSaidas("norte", null);
        salaJogos.ajustarSaidas("leste", refeitorio);
        salaJogos.ajustarSaidas("sul", corredor);
        salaJogos.ajustarSaidas("oeste", null);
        salaJogos.ajustarSaidas("noroeste",null);
        salaJogos.ajustarSaidas("sudeste",null);

        salaArmas.ajustarSaidas("norte", null);
        salaArmas.ajustarSaidas("leste", null);
        salaArmas.ajustarSaidas("sul", null);
        salaArmas.ajustarSaidas("oeste", salaTreinamento);
        salaArmas.ajustarSaidas("noroeste",null);
        salaArmas.ajustarSaidas("sudeste",null);

        banheiro1.ajustarSaidas("norte", null);
        banheiro1.ajustarSaidas("leste", salaTreinamento);
        banheiro1.ajustarSaidas("sul", null);
        banheiro1.ajustarSaidas("oeste", null);
        banheiro1.ajustarSaidas("noroeste",null);
        banheiro1.ajustarSaidas("sudeste",null);

        armazem.ajustarSaidas("norte", salaTreinamento);
        armazem.ajustarSaidas("leste", null);
        armazem.ajustarSaidas("sul", null);
        armazem.ajustarSaidas("oeste", adega);
        armazem.ajustarSaidas("noroeste",null);
        armazem.ajustarSaidas("sudeste",null);

        refeitorio.ajustarSaidas("norte", null);
        refeitorio.ajustarSaidas("leste", garagem);
        refeitorio.ajustarSaidas("sul", salaTreinamento);
        refeitorio.ajustarSaidas("oeste", salaJogos);
        refeitorio.ajustarSaidas("noroeste",null);
        refeitorio.ajustarSaidas("sudeste",null);

        salaReunioes.ajustarSaidas("norte", salaTreinamento);
        salaReunioes.ajustarSaidas("leste", null);
        salaReunioes.ajustarSaidas("sul", null);
        salaReunioes.ajustarSaidas("oeste", null);
        salaReunioes.ajustarSaidas("noroeste",null);
        salaReunioes.ajustarSaidas("sudeste",null);

        garagem.ajustarSaidas("norte", fora);
        garagem.ajustarSaidas("leste", null);
        garagem.ajustarSaidas("sul", null);
        garagem.ajustarSaidas("oeste", refeitorio);
        garagem.ajustarSaidas("noroeste",null);
        garagem.ajustarSaidas("sudeste",null);

        salaTreinamento.ajustarSaidas("norte", refeitorio);
        salaTreinamento.ajustarSaidas("leste", salaArmas);
        salaTreinamento.ajustarSaidas("sul", salaReunioes);
        salaTreinamento.ajustarSaidas("sudeste", armazem);
        salaTreinamento.ajustarSaidas("oeste", dormitorio);  
        salaTreinamento.ajustarSaidas("noroeste", banheiro1);

        fora.ajustarSaidas("norte", null);
        fora.ajustarSaidas("leste", null);
        fora.ajustarSaidas("sul", garagem);
        fora.ajustarSaidas("oeste", null);
        fora.ajustarSaidas("noroeste",null);
        fora.ajustarSaidas("sudeste",null);
      
        ambienteAtual = fora; // o jogo comeca do lado de fora
    }

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.

        boolean terminado = false;
        while (!terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo ao World of Zuul!");
        System.out.println("World of Zuul eh um novo jogo de aventura, incrivelmente chato.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();

        imprimirLocalizacaoAtual();
    }

    public void imprimirLocalizacaoAtual() {
        System.out.println("Voce esta " + ambienteAtual.getDescricao());

        System.out.print("Saidas: " + ambienteAtual.direcoesDeSaida());
        System.out.println();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * 
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) {
        boolean querSair = false;

        if (comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        } else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        } else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        } else if (palavraDeComando.equals("observar")) {
            observar(comando);
        }

        return querSair;
    }

    private void observar(Comando comando) {
        imprimirLocalizacaoAtual();
    }

    // Implementacoes dos comandos do usuario

    /**
     * Printe informacoes de ajuda.
     * Aqui nos imprimimos algo bobo e enigmatico e a lista de
     * palavras de comando
     */
    private void imprimirAjuda() {
        System.out.println("Voce esta perdido. Voce esta sozinho. Voce caminha");
        System.out.println("pela universidade.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println(analisador.getPalavrasComando());
    }

    /**
     * Tenta ir em uma direcao. Se existe uma saida entra no
     * novo ambiente, caso contrario imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        proximoAmbiente = ambienteAtual.getAmbiente(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        } else {
            ambienteAtual = proximoAmbiente;
            imprimirLocalizacaoAtual();
        }
    }

    /**
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * 
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        } else {
            return true; // sinaliza que nos queremos sair
        }
    }
}
