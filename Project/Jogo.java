import java.util.ArrayList;
import java.util.Random;

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

// Atualizado por Bruno Firmino e Luiz Victor Soriano
public class Jogo {
    private Analisador analisador;
    private Ambiente ambienteAtual;
    private ArrayList<Personagem> inimigos;
    private ArrayList<Ambiente> listaAmbientes;
    private ArrayList<Item> listaColetes;
    private Personagem agente;
    private boolean terminado;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        listaAmbientes = new ArrayList<>();
        inimigos = new ArrayList<>();
        listaColetes = new ArrayList<>();
        criarAmbientes();
        criarAgente();
        criarInimigos();
        criarColetes();
        analisador = new Analisador();
        terminado = false;
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */

    private void criarAmbientes() {
        Ambiente fora, corredor, adega, dormitorio, banheiro2, salaJogos, banheiro1, armazem, salaReunioes, salaArmas,
                garagem, refeitorio, salaTreinamento;

        // cria os ambientes
        fora = new Ambiente("Fora da Base", "fora da base da mafia");
        listaAmbientes.add(fora);
        corredor = new Ambiente("Corredor", "no corredor da base da mafia");
        listaAmbientes.add(corredor);
        adega = new Ambiente("Adega de Vinhos", "na adega de vinhos");
        listaAmbientes.add(adega);
        dormitorio = new Ambiente("Dormitório", "no dormitorio");
        listaAmbientes.add(dormitorio);
        banheiro2 = new Ambiente("Banheiro 2", "no banheiro");
        listaAmbientes.add(banheiro2);
        salaJogos = new Ambiente("Sala de Jogos", "na sala de jogos");
        listaAmbientes.add(salaJogos);
        banheiro1 = new Ambiente("Banheiro 1", "no banheiro");
        listaAmbientes.add(banheiro1);
        armazem = new Ambiente("Armazém", "no armazem");
        listaAmbientes.add(armazem);
        salaReunioes = new Ambiente("Sala de Reuniões", "na sala de reunioes");
        listaAmbientes.add(salaReunioes);
        salaArmas = new Ambiente("Sala de Armas", "na sala de armas");
        listaAmbientes.add(salaArmas);
        garagem = new Ambiente("Garagem", "na garagem");
        listaAmbientes.add(garagem);
        refeitorio = new Ambiente("Refeitório", "no refeitorio");
        listaAmbientes.add(refeitorio);
        salaTreinamento = new Ambiente("Sala de Treinamento", "na sala de treinamento");
        listaAmbientes.add(salaTreinamento);

        corredor.ajustarSaidas("norte", salaJogos);
        corredor.ajustarSaidas("leste", dormitorio);
        corredor.ajustarSaidas("sul", adega);
        corredor.ajustarSaidas("oeste", banheiro2);
        corredor.ajustarSaidas("noroeste", null);
        corredor.ajustarSaidas("sudeste", null);

        adega.ajustarSaidas("norte", corredor);
        adega.ajustarSaidas("leste", armazem);
        adega.ajustarSaidas("sul", null);
        adega.ajustarSaidas("oeste", null);
        adega.ajustarSaidas("noroeste", null);
        adega.ajustarSaidas("sudeste", null);

        dormitorio.ajustarSaidas("norte", null);
        dormitorio.ajustarSaidas("leste", salaTreinamento);
        dormitorio.ajustarSaidas("sul", null);
        dormitorio.ajustarSaidas("oeste", corredor);
        dormitorio.ajustarSaidas("noroeste", null);
        dormitorio.ajustarSaidas("sudeste", null);

        banheiro2.ajustarSaidas("norte", null);
        banheiro2.ajustarSaidas("leste", corredor);
        banheiro2.ajustarSaidas("sul", null);
        banheiro2.ajustarSaidas("oeste", null);
        banheiro2.ajustarSaidas("noroeste", null);
        banheiro2.ajustarSaidas("sudeste", null);

        salaJogos.ajustarSaidas("norte", null);
        salaJogos.ajustarSaidas("leste", refeitorio);
        salaJogos.ajustarSaidas("sul", corredor);
        salaJogos.ajustarSaidas("oeste", null);
        salaJogos.ajustarSaidas("noroeste", null);
        salaJogos.ajustarSaidas("sudeste", null);

        salaArmas.ajustarSaidas("norte", null);
        salaArmas.ajustarSaidas("leste", null);
        salaArmas.ajustarSaidas("sul", null);
        salaArmas.ajustarSaidas("oeste", salaTreinamento);
        salaArmas.ajustarSaidas("noroeste", null);
        salaArmas.ajustarSaidas("sudeste", null);

        banheiro1.ajustarSaidas("norte", null);
        banheiro1.ajustarSaidas("leste", salaTreinamento);
        banheiro1.ajustarSaidas("sul", null);
        banheiro1.ajustarSaidas("oeste", null);
        banheiro1.ajustarSaidas("noroeste", null);
        banheiro1.ajustarSaidas("sudeste", null);

        armazem.ajustarSaidas("norte", salaTreinamento);
        armazem.ajustarSaidas("leste", null);
        armazem.ajustarSaidas("sul", null);
        armazem.ajustarSaidas("oeste", adega);
        armazem.ajustarSaidas("noroeste", null);
        armazem.ajustarSaidas("sudeste", null);

        refeitorio.ajustarSaidas("norte", null);
        refeitorio.ajustarSaidas("leste", garagem);
        refeitorio.ajustarSaidas("sul", salaTreinamento);
        refeitorio.ajustarSaidas("oeste", salaJogos);
        refeitorio.ajustarSaidas("noroeste", null);
        refeitorio.ajustarSaidas("sudeste", null);

        salaReunioes.ajustarSaidas("norte", salaTreinamento);
        salaReunioes.ajustarSaidas("leste", null);
        salaReunioes.ajustarSaidas("sul", null);
        salaReunioes.ajustarSaidas("oeste", null);
        salaReunioes.ajustarSaidas("noroeste", null);
        salaReunioes.ajustarSaidas("sudeste", null);

        garagem.ajustarSaidas("norte", fora);
        garagem.ajustarSaidas("leste", null);
        garagem.ajustarSaidas("sul", null);
        garagem.ajustarSaidas("oeste", refeitorio);
        garagem.ajustarSaidas("noroeste", null);
        garagem.ajustarSaidas("sudeste", null);

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
        fora.ajustarSaidas("noroeste", null);
        fora.ajustarSaidas("sudeste", null);

        ambienteAtual = fora; // o jogo comeca do lado de fora
    }

    private void criarInimigos() {
        Personagem inimigo1 = new Capanga(100, new Arma("FUZIL", 20));
        Personagem inimigo2 = new Capanga(100, new Arma("PONTO 50", 40));
        Personagem inimigo3 = new Capanga(100, new Arma("AK-47", 27));
        Personagem inimigo4 = new Capanga(100, new Arma("FACA", 10));
        Personagem inimigo5 = new Capanga(100, new Arma("FUZIL DE PRECISÂO", 35));
        Personagem chefe = new Chefe(250, new Arma("MACHINE GUN", 85));

        inimigos.add(inimigo1);
        inimigos.add(inimigo2);
        inimigos.add(inimigo3);
        inimigos.add(inimigo4);
        inimigos.add(inimigo5);
        inimigos.add(chefe);

        randomizarInimigos();

    }

    private void criarAgente() {
        agente = new Agente(150, new Arma("ARMA .38", 30));
    }

    private void criarColetes() {
        Item colete1 = new Colete("Colete Tatico Verde Escuro", 30);
        Item colete2 = new Colete("Colete Tatico Preto", 70);
        Item colete3 = new Colete("Colete Tatico Ciano", 25);
        Item colete4 = new Colete("Colete Tatico Cinza", 60);
        Item colete5 = new Colete("Colete Tatico Verde Claro", 50);
        Item colete6 = new Colete("Colete Tatico Camuflado", 45);

        listaColetes.add(colete1);
        listaColetes.add(colete2);
        listaColetes.add(colete3);
        listaColetes.add(colete4);
        listaColetes.add(colete5);
        listaColetes.add(colete6);

        randomizarColetes();

    }

    private void randomizarInimigos() {
        Random random = new Random();
        int num, i = 0;
        while (i < inimigos.size()) {
            num = random.nextInt(listaAmbientes.size());
            if (listaAmbientes.get(num).getInimigo() == null && num > 0) {
                System.out.println(listaAmbientes.get(num).getNome() + " --- inimigo");
                listaAmbientes.get(num).setInimigo(inimigos.get(i));
                i++;
            }
        }
    }

    private void randomizarColetes() {
        Random random = new Random();
        int num, i = 0;
        while (i < listaColetes.size()) {
            num = random.nextInt(listaAmbientes.size());
            if (listaAmbientes.get(num).getColete() == null && num > 0) {
                System.out.println(listaAmbientes.get(num).getNome() + " --- colete");
                listaAmbientes.get(num).setColete(listaColetes.get(i));
                i++;
            }
        }
    }

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.

        while (!terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Nesse jogo, você é um agente secreto contratado pelo federal da Itália.");
        System.out.println("Para acabar com a máfia Yakult, liberado por Chamyto.");
        System.out.println("O agente deve enfrentar os capangas da máfia até chegar ao seu líder, para derrotá-lo. Porém, vai que você encontre o líder antes?");
        System.out.println("Caso esteja com dúvida, digite 'ajuda'.");
        System.out.println();

        imprimirLocalizacaoAtual();
    }

    public void verificarInimigo(Ambiente ambienteAtual) {
        Personagem inimigo = ambienteAtual.getInimigo();
        if (inimigo != null) {
            if(inimigo instanceof Chefe){
                System.out.println("Cuidado, você encontrou o chefão da Máfia!!");
                int simulacao = Confronto.simularConfronto((Agente)agente, (Chefe)inimigo);
                if(simulacao == -1){
                    System.out.println("Você ainda é muito fraco para confrontar o chefe, deseja confrontar ou fugir?");
                }else if(simulacao == 0){
                    System.out.println("Você ainda é muito fraco para confrontar o chefe, porém dependendo da sua sorte há uma pequena chance de derrotá-lo, deseja arriscar e confrontar ou fugir?");
                }else{
                     System.out.println("Você parece bem forte, irá confrontar ou fugir?");
                }
            }else{
                System.out.println("Há um capanga neste local, confrontar? ou fugir?");
            }
            Comando comando = analisador.pegarComando();
            processarComando(comando);
        } else {
            System.out.println("Parece não haver inimigos neste local");
        }
    }

    public void verificarColete(Ambiente ambienteAtual) {
        if (ambienteAtual.getColete() != null) {
            System.out.println("Há um colete neste local! Equipar?");
            Comando comando = analisador.pegarComando();
            processarComando(comando);
        } else {
            System.out.println("Parece não haver coletes neste local");
        }
    }

    public void imprimirLocalizacaoAtual() {
        System.out.println("Você está " + ambienteAtual.getDescricao());
        System.out.print("Saídas: " + ambienteAtual.direcoesDeSaida());
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
            observar();
        } else if (palavraDeComando.equals("confrontar")) {
            confrontar();
        } else if (palavraDeComando.equals("fugir")) {
            irParaAmbiente(comando);
        } else if (palavraDeComando.equals("equipar")) {
            equiparColete();
        }

        return querSair;
    }

    private void observar() {
        verificarInimigo(ambienteAtual);
        verificarColete(ambienteAtual);
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
        System.out.println("pelos cômodos da base máfia.");
        System.out.println();
        System.out.println("Suas palavras de comando são:");
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

    private void confrontar() {
        Personagem inimigo = ambienteAtual.getInimigo();
        int vidaInimigo = inimigo.getPontosDeVida();
        int vidaAgente = agente.getPontosDeVida();
        if (inimigo instanceof Chefe) {
            System.out.println("Você inicio um confronto contra o grande chefão da máfia. Ele possui incríveis " + vidaInimigo + " pontos de vida");
            while (vidaInimigo > 0 && vidaAgente > 0) {
                System.out.println("Você atirou no chefe");
                Confronto.darDanoChefe((Agente) agente, (Chefe) inimigo);
                vidaInimigo = inimigo.getPontosDeVida();
                if (vidaInimigo < 0) {
                    System.out.println("Parabéns, você cumpriu seu objetivo e derrotou o chefe da base da máfia!");
                    
                } else {
                    System.out.println("O chefe ainda está de pé com: " + vidaInimigo + " pontos de vida");
                    System.out.println("O chefe não deixa barato, ele atirou em você!");
                    Confronto.darDanoChefeAgente((Agente) agente, (Chefe) inimigo);
                    vidaAgente = agente.getPontosDeVida();
                    System.out.println("Sua vida caiu para " + vidaAgente);
                    if (vidaAgente <= 0) {
                        System.out.println("GAME OVER!!!!!");
                        terminado = true;
                    }
                }
            }
        } else {
            System.out.println("Você iniciou um confronto contra um capanga da máfia com " + vidaInimigo + " pontos de vida");
            while (vidaInimigo > 0 && vidaAgente > 0) {
                System.out.println("Você atirou no capanga");
                Confronto.darDanoCapanga((Agente) agente, (Capanga) inimigo);
                vidaInimigo = inimigo.getPontosDeVida();
                if (vidaInimigo < 0) {
                    System.out.println("Você derrotou o capanga");
                    System.out.println("Você pegou a arma " + inimigo.getArma().getNome() + " dele e adquiriu " + inimigo.calculaPoder() + " de poder para sua arma");
                    Agente agenteAux = (Agente) agente;
                    agenteAux.aumentarPoder(inimigo.calculaPoder());
                    ambienteAtual.removerInimigo();
                } else {
                    System.out.println("Vida do capanga: " + vidaInimigo);
                    System.out.println("O capanga atirou em você!");
                    Confronto.darDanoCapangaAgente((Agente) agente, (Capanga) inimigo);
                    vidaAgente = agente.getPontosDeVida();
                    System.out.println("Sua vida caiu para " + vidaAgente);
                    if (vidaAgente <= 0) {
                        System.out.println("GAME OVER!!!!!");
                        terminado = true;
                    }
                }
            }

        }
    }

    private void equiparColete() {
        Colete colete = (Colete) ambienteAtual.getColete();
        Agente agenteAux = (Agente) agente;
        System.out.println("Este " + colete.getNome() + " possui " + colete.getBonusVida() + " pontos de vida");
        agenteAux.setColete(colete);
        System.out.println("Agora você possui " + agente.getPontosDeVida() + " pontos de vida");
        ambienteAtual.removerColete();
    }
}
