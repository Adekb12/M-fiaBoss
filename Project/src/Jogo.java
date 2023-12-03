import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Essa é a classe principal da aplicacao "Mafia Boss".
 * "Mafia Boss" é um jogo de ação simples, baseado em texto.
 * Usuarios podem caminhar em um cenário, encontrar itens e derrotar seus
 * inimigos.
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 * "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os
 * ambientes, cria o analisador e comeca o jogo. Ela tambeme avalia e
 * executa os comandos que o analisador retorna.
 * 
 * @author Bruno firmino, Gabriel Furtado, luiz Victor Soriano, Mardem Arantes.
 */

public class Jogo {
    private Analisador analisador;
    private Ambiente ambienteAtual;
    private ArrayList<Personagem> inimigos;
    private ArrayList<Ambiente> listaAmbientes;
    private ArrayList<Item> listaColetes;
    private Personagem agente;
    private boolean terminado;
    private int inimigosDerrotados;
    private String logJogo;

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
        inimigosDerrotados = 0;
        logJogo = imprimirBoasVindas() + imprimirLocalizacaoAtual();
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */

    private void criarAmbientes() {
        Ambiente frenteGaragem, corredor, adega, dormitorio, banheiro2, salaJogos, banheiro1, armazem, salaReunioes,
                salaArmas,
                garagem, refeitorio, salaTreinamento;

        // cria os ambientes
        frenteGaragem = new Ambiente("Na frente da garagem", "na frente da garagem da base da mafia");
        listaAmbientes.add(frenteGaragem);
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

        garagem.ajustarSaidas("norte", frenteGaragem);
        garagem.ajustarSaidas("leste", null);
        garagem.ajustarSaidas("sul", null);
        garagem.ajustarSaidas("oeste", refeitorio);
        garagem.ajustarSaidas("noroeste", null);
        garagem.ajustarSaidas("sudeste", null);

        salaTreinamento.ajustarSaidas("norte", refeitorio);
        salaTreinamento.ajustarSaidas("leste", salaArmas);
        salaTreinamento.ajustarSaidas("sudeste", salaReunioes);
        salaTreinamento.ajustarSaidas("sul", armazem);
        salaTreinamento.ajustarSaidas("oeste", dormitorio);
        salaTreinamento.ajustarSaidas("noroeste", banheiro1);

        frenteGaragem.ajustarSaidas("norte", null);
        frenteGaragem.ajustarSaidas("leste", null);
        frenteGaragem.ajustarSaidas("sul", garagem);
        frenteGaragem.ajustarSaidas("oeste", null);
        frenteGaragem.ajustarSaidas("noroeste", null);
        frenteGaragem.ajustarSaidas("sudeste", null);

        ambienteAtual = frenteGaragem; // o jogo comeca do lado de frenteGaragem
    }

    /**
     * Método que cria os inimigos, capangas e chefe, e chama o método para os
     * randomizar.
     */
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

    /**
     * Método que cria os coletes e chama o método para os radomizar.
     */

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

    /**
     * Método que irá criar o agente.
     */
    private void criarAgente() {
        agente = new Agente(150, new Arma("ARMA .38", 30));
    }

    /**
     * Método que retorna a vida do agente para a interface.
     * 
     * @return int - vida do agente.
     */
    public int pegarVidaAgente() {
        return agente.getPontosDeVida();
    }

    /**
     * Método que retorna o poder da arma do agente para a interface.
     * 
     * @return int - poder do agente.
     */
    public int pegarPoderAgente() {
        return agente.getArma().getPoder();
    }

    /**
     * Método retorna a quantidade de inimigos derrotados para a interface.
     * 
     * @return int - quantidade de inimigos derrotados.
     */
    public int pegarInimigosDerrotados() {
        return inimigosDerrotados;
    }

    /**
     * Método que irá randomizar um número no intervalo da quantidade de ambientes.
     * Dado esse número, que corresponde a um ambiente na listaAmbientes, um inimigo
     * será associado a ele.
     */
    private void randomizarInimigos() {
        Random random = new Random();
        int num, i = 0;
        while (i < inimigos.size()) {
            num = random.nextInt(listaAmbientes.size());
            if (listaAmbientes.get(num).getInimigo() == null && num > 0) {
                listaAmbientes.get(num).setInimigo(inimigos.get(i));
                i++;
            }
        }
    }

    /**
     * Método que irá randomizar um número no intervalo da quantidade de ambientes.
     * Dado esse número, que corresponde a um ambiente na listaAmbientes, um colete
     * será associado a ele.
     */
    private void randomizarColetes() {
        Random random = new Random();
        int num, i = 0;
        while (i < listaColetes.size()) {
            num = random.nextInt(listaAmbientes.size());
            if (listaAmbientes.get(num).getColete() == null && num > 0) {
                listaAmbientes.get(num).setColete(listaColetes.get(i));
                i++;
            }
        }
    }

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     * 
     * @param entrada - entrada digitada.
     * @return String - mensagem baseada no comando digitado.
     */
    public String jogar(String entrada) {

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.
        Comando comando = analisador.pegarComando(entrada);
        String processado = processarComando(comando);
        logJogo += processado;
        if (!terminado) {
            return processado;
        }
        return "Obrigado por jogar. Digite sair para finalizar";
    }

    /**
     * Método que irá retornar as saídas a partir de um ambiente.
     * 
     * @return String - retorna os possíveis ambientes a partir do ambiente atual.
     */
    public String imprimirSaidas() {
        return "Saídas: " + ambienteAtual.direcoesDeSaida();
    }

    /**
     * Método que irá retornar a descrição do ambiente em que o agente está.
     * 
     * @return String - retorna a descrição do ambiente.
     */
    public String imprimirLocalizacaoAtual() {
        return "Você está " + ambienteAtual.getDescricao() + "\n";
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     * 
     * @return String - mensagem de baoas.
     */
    public String imprimirBoasVindas() {
        return "Nesse jogo, você é um agente secreto contratado\n"
                + "Para acabar com a máfia Yakult, liderado por Chamyto.\n" +
                "O agente deve enfrentar os capangas da máfia até chegar ao seu líder, para derrotá-lo. Porém, vai que você encontre o líder antes?\n"
                + "Caso esteja com dúvida, digite 'ajuda'.\n";
    }

    /**
     * Método que irá verificar se há um inimigo no ambiente atual. Além disso, irá
     * diferenciar o inimigo entre o chefe e o capanga, retornando mensagens
     * diferentes.
     * 
     * @return String - mensagem baseado na presença de um inimigo e o seu tipo.
     */
    public String verificarInimigo() {
        String verificacao = "";
        Personagem inimigo = ambienteAtual.getInimigo();
        if (inimigo != null) {
            if (inimigo instanceof Chefe) {
                verificacao = "Cuidado, você encontrou o chefão da Máfia!!\n";
                int simulacao = Confronto.simularConfronto((Agente) agente, (Chefe) inimigo);
                if (simulacao == -1) {
                    verificacao += "Você ainda é muito fraco para confrontar o chefe, deseja confrontar ou fugir?";
                } else if (simulacao == 0) {
                    verificacao += "Você ainda é muito fraco para confrontar o chefe, porém dependendo da sua sorte há uma pequena chance de derrotá-lo, deseja arriscar e confrontar ou fugir?";
                } else {
                    verificacao += "Você parece bem forte, irá confrontar ou fugir?";
                }
                return verificacao;
            } else {
                return "Há um capanga neste local, confrontar? ou fugir?";
            }
        } else {
            return "Parece não haver inimigos neste local\n" + imprimirSaidas();
        }
    }

    /**
     * Método que verifica se há colete no ambiente e o equipa.
     * 
     * @return String - mensagem baseada na presença do colete.
     */
    public String verificarColete() {
        if (ambienteAtual.getColete() != null) {
            return "Você encontrou um colete!" + equiparColete() + "Observar por inimigos?\n";
        } else {
            return "Parece não haver coletes neste local\n" + "Observar por inimigos?\n";
        }
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * 
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private String processarComando(Comando comando) {

        if (comando.ehDesconhecido()) {
            return "Eu nao entendi o que voce disse...";
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            return imprimirAjuda();
        } else if (palavraDeComando.equals("ir")) {
            return irParaAmbiente(comando);
        } else if (palavraDeComando.equals("observar")) {
            return verificarInimigo();
        } else if (palavraDeComando.equals("confrontar")) {
            return confrontar();
        } else if (palavraDeComando.equals("fugir")) {
            return irParaAmbiente(comando);
        }
        return "Eu nao entendi o que voce disse...";
    }

    // Implementacoes dos comandos do usuario

    /**
     * Método que retorna
     * as palavras-chave do jogo.
     * 
     * @return String -mensagem com as palavras-chave.
     */
    private String imprimirAjuda() {
        return "Comandos:\n" + "- ir: ir para uma direção. Ex: ir norte \n"
                + "- observar: observa o ambiente à procura de inimigos\n"
                + "- fugir: quando você não quer confrontar o chefe\n"
                + "- confrontar: quando você quer entrar em confronto contra um inimigo\n"
                + "- sair: utilizado para encerrar o jogo\n"
                + "OBS: Possíveis direções: norte, sul, leste, oeste, noroeste e sudeste";
    }

    /**
     * Tenta ir em uma direcao. Se existe uma saida entra no
     * novo ambiente, caso contrario imprime mensagem de erro.
     */
    private String irParaAmbiente(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            return "Ir pra onde?\n" + imprimirSaidas();
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        proximoAmbiente = ambienteAtual.getAmbiente(direcao);

        if (proximoAmbiente == null) {
            return "Nao ha passagem!";
        } else {
            ambienteAtual = proximoAmbiente;
            return imprimirLocalizacaoAtual() + verificarColete() + imprimirSaidas();
        }
    }

    /**
     * Método que irá chamar os métodos da classe Confronto, em que o agente dará
     * dano no capanga ou no chefe, além de sofrer dano dos inimigos.
     * 
     * @return String - mensagem baseado no resultado do confronto.
     */
    private String confrontar() {
        String confronto = "";
        Personagem inimigo = ambienteAtual.getInimigo();
        int vidaInimigo = inimigo.getPontosDeVida();
        int vidaAgente = agente.getPontosDeVida();
        if (inimigo instanceof Chefe) {
            confronto += "Você inicio um confronto contra o grande chefão da máfia. Ele possui incríveis " + vidaInimigo
                    + " pontos de vida\n";
            while (vidaInimigo > 0 && vidaAgente > 0) {
                confronto += "Você atirou no chefe\n";
                Confronto.darDanoChefe((Agente) agente, (Chefe) inimigo);
                vidaInimigo = inimigo.getPontosDeVida();
                if (vidaInimigo <= 0) {
                    confronto += "Parabéns, você cumpriu seu objetivo e derrotou o chefe da base da máfia!\n";
                    inimigosDerrotados++;
                    terminado = true;
                } else {
                    confronto += "O chefe ainda está de pé com: " + vidaInimigo + " pontos de vida\n"
                            + "O chefe não deixa barato, ele atirou em você!\n" + "Você levou dano!!\n";
                    Confronto.darDanoChefeAgente((Agente) agente, (Chefe) inimigo);
                    vidaAgente = agente.getPontosDeVida();
                    if (vidaAgente <= 0) {
                        confronto += "GAME OVER!!!!!";
                        terminado = true;
                    }
                }
            }
        } else {
            confronto += "Você iniciou um confronto contra um capanga da máfia com " + vidaInimigo
                    + " pontos de vida\n";
            while (vidaInimigo > 0 && vidaAgente > 0) {
                confronto += "Você atirou no capanga\n";
                Confronto.darDanoCapanga((Agente) agente, (Capanga) inimigo);
                vidaInimigo = inimigo.getPontosDeVida();
                if (vidaInimigo <= 0) {
                    confronto += "Você derrotou o capanga\n" + "Você pegou a arma " + inimigo.getArma().getNome()
                            + " dele e adquiriu mais poder\n" + imprimirSaidas();
                    Agente agenteAux = (Agente) agente;
                    agenteAux.aumentarPoder(inimigo.calculaPoder());
                    ambienteAtual.removerInimigo();
                    inimigosDerrotados++;
                } else {
                    confronto += "Vida do capanga: " + vidaInimigo + "\nO capanga atirou em você!\n"
                            + "Você levou dano!!\n";
                    Confronto.darDanoCapangaAgente((Agente) agente, (Capanga) inimigo);
                    vidaAgente = agente.getPontosDeVida();
                    if (vidaAgente <= 0) {
                        confronto += "GAME OVER!!!!!";
                        terminado = true;
                    }
                }
            }

        }
        return confronto;
    }

    /**
     * Método que irá atualizar o colete do agente achado no amabiente atual.
     * 
     * @return String - mensagem mostrando o nome colete e quanto foi o bônus de
     *         vida.
     */
    private String equiparColete() {
        Colete colete = (Colete) ambienteAtual.getColete();
        Agente agenteAux = (Agente) agente;
        agenteAux.setColete(colete);
        ambienteAtual.removerColete();
        return " Este " + colete.getNome() + " possui " + colete.getBonusVida() + " pontos de vida\n"
                + "Você recebeu um aumento na vida\n";
    }

    /**
     * Método responsável por gravar o histórico do jogo jogado em um um arquivo de texto.
     */
    public void gravarLog() {
        try (FileWriter log = new FileWriter("LogJogo.txt", false)) {
            log.write(logJogo);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
