import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface extends Jogo implements ActionListener {
    private JFrame janela;
    private ImageIcon planta;
    private JLabel exibirPlanta;
    private JTextField campoEntradaDados;
    private String tela;
    private JPanel painelCentral;
    private JPanel painelInferior;
    private JTextArea painelRespostas;
    private JPanel painelComando;
    private JPanel painelPersonagem;
    private JButton enviar;
    private JTextField campoVida;
    private JTextField campoPoder;
    private JTextField campoInimigos;

    public Interface() {
        super();
        planta = new ImageIcon("./Imagens/plantaBaseMafia.jpg");
        janela = new JFrame("Mafia Boss");//
        painelCentral = new JPanel();
        painelInferior = new JPanel();
        painelRespostas = new JTextArea(30, 100);
        painelComando = new JPanel();
        painelPersonagem = new JPanel();
        enviar = new JButton("Enviar resposta");
        campoVida = new JTextField();
        campoPoder = new JTextField();
        campoInimigos = new JTextField();
        criarJanela();
        tela = "";
    }

    private void criarJanela() {
        janela.setSize(1300, 700);// redimensiona a tela
        janela.setLayout(new BorderLayout());// define o layout da janela
        janela.setLocationRelativeTo(null);// para a tela sempre abrir no meio
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// encerrar o programa quando clicar no "x"
        campoSuperior();
        campoInferior();
        montarCampoPersonagem();

    }

    private void campoSuperior() {
        painelCentral.setPreferredSize(new Dimension(planta.getIconWidth(), planta.getIconHeight()));
        painelCentral.setBorder(BorderFactory.createTitledBorder("Planta da Base"));
        exibirPlanta = new JLabel(planta);// adiciona em uma label
        painelCentral.add(exibirPlanta);// adiciona na janela na posicao norte

        janela.add(painelCentral, BorderLayout.CENTER);

    }

    private void campoInferior() {

        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.Y_AXIS));// organiza os elementos pelo eixo y
        painelInferior.setPreferredSize(new Dimension(1000, 150));
        painelInferior.setBorder(BorderFactory.createTitledBorder("Campo de dados"));
        montarCampoResposta(painelInferior);

        montarCampoEntradaDados(painelInferior);

        janela.add(painelInferior, BorderLayout.SOUTH);
    }

    private void montarCampoResposta(JPanel painelPertecente) {
        // subpainel que envia as mensagens para o jogador
        painelRespostas.setPreferredSize(new Dimension(600, 100));
        painelRespostas.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(painelRespostas);
        painelPertecente.add(scrollPane);
    }

    private void montarCampoEntradaDados(JPanel painelPertencente) {

        painelComando.setPreferredSize(new Dimension(850, 50));
        campoEntradaDados = new JTextField();// cria um campo de texto
        campoEntradaDados.setPreferredSize(new Dimension(600, 30));
        painelComando.add(campoEntradaDados);
        painelComando.add(enviar);
        painelPertencente.add(painelComando);
        enviar.addActionListener(this);

    }

    private void montarCampoPersonagem() {
        painelPersonagem.setPreferredSize(new Dimension(200, 500));
        painelPersonagem.setBorder(BorderFactory.createTitledBorder("Status"));
        painelPersonagem.setLayout(new BoxLayout(painelPersonagem, BoxLayout.Y_AXIS));
        montarPoder(painelPersonagem);
        montarVida(painelPersonagem);
        montarInimigo(painelPersonagem);
        janela.add(painelPersonagem, BorderLayout.EAST);
    }

    private void montarPoder(JPanel painelPertencente) {
        campoPoder.setEditable(false);
        campoPoder.setText("Poder:");
        painelPertencente.add(campoPoder);
    }

    private void montarVida(JPanel painelPertencente) {
        campoVida.setEditable(false);
        campoVida.setText("Vida:");
        painelPertencente.add(campoVida);
    }

    private void montarInimigo(JPanel painelPertencente) {
        campoInimigos.setEditable(false);
        campoInimigos.setText("Inimigos Derrotados:");
        painelPertencente.add(campoInimigos);
    }

    public void exibir() {
        janela.setVisible(true);
        exibirMensagem(imprimirBoasVindas() + imprimirLocalizacaoAtual() + imprimirSaidas());
    }

    public void exibirMensagem(String mensagem) {

        if (mensagem.equals("Obrigado por jogar")) {
            painelRespostas.setText(mensagem);
            gravarLog();
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            janela.dispose();
        } else {
            tela += mensagem;
            painelRespostas.setText(tela);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = campoEntradaDados.getText();
        campoEntradaDados.setText("");
        tela = "";
        if (comando.equals("sair")) {
            gravarLog();
            janela.dispose();// fecha a janela
        }
        executar(comando);
    }

    private void executar(String comando) {
        exibirMensagem(jogar(comando));
        atualizarStatus();
    }

    private void atualizarStatus() {
        int vida = pegarVidaAgente();
        int poder = pegarPoderAgente();
        int inimigos = pegarInimigosDerrotados();
        campoVida.setText("Vida:" + vida);
        campoPoder.setText("Poder:" + poder);
        campoInimigos.setText("Inimigos Derrotados: " + inimigos);
    }

}
