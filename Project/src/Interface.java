import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe responsável por fazer a interface do jogo Mafia Boss, sendo uma
 * subclasse da classe Jogo, por motivo do jogo conter a interface.
 * 
 * @author Bruno Henrique Firmino e Gabriel Furtado.
 */
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
        planta = new ImageIcon("Project/src/plantaBaseMafia.jpg");
        janela = new JFrame("Mafia Boss");
        painelCentral = new JPanel();
        painelInferior = new JPanel();
        painelRespostas = new JTextArea(100, 100);
        painelComando = new JPanel();
        painelPersonagem = new JPanel();
        enviar = new JButton("Enviar resposta");
        campoVida = new JTextField();
        campoPoder = new JTextField();
        campoInimigos = new JTextField();
        criarJanela();
        tela = "";
    }

    /**
     * Método responsável por configurar a janela presente na interface.
     */
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

    /**
     * Método responsável por configurar o campo superior da janela.
     */
    private void campoSuperior() {
        painelCentral.setPreferredSize(new Dimension(planta.getIconWidth(), planta.getIconHeight()));
        painelCentral.setBorder(BorderFactory.createTitledBorder("Planta da Base"));
        exibirPlanta = new JLabel(planta);// adiciona em uma label
        painelCentral.add(exibirPlanta);// adiciona na janela na posicao norte

        janela.add(painelCentral, BorderLayout.CENTER);

    }

    /**
     * Método responsável por configurar o campo inferior da janela.
     */
    private void campoInferior() {
        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.Y_AXIS));// organiza os elementos pelo eixo y
        painelInferior.setPreferredSize(new Dimension(1000, 150));
        painelInferior.setBorder(BorderFactory.createTitledBorder("Campo de dados"));
        montarCampoResposta(painelInferior);

        montarCampoEntradaDados(painelInferior);

        janela.add(painelInferior, BorderLayout.SOUTH);
    }

    /**
     * Método responsável por mostrar as mensagens necessárias para o usuário.
     * 
     * @param painelPertecente
     */
    private void montarCampoResposta(JPanel painelPertecente) {
        painelRespostas.setPreferredSize(new Dimension(600, 100));
        painelRespostas.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(painelRespostas);
        painelPertecente.add(scrollPane);
    }

    /**
     * Método responsável por capturar os dados digitados pelo usuário.
     * 
     * @param painelPertencente
     */
    private void montarCampoEntradaDados(JPanel painelPertencente) {
        painelComando.setPreferredSize(new Dimension(850, 50));
        campoEntradaDados = new JTextField();// cria um campo de texto
        campoEntradaDados.setPreferredSize(new Dimension(600, 30));
        painelComando.add(campoEntradaDados);
        painelComando.add(enviar);
        painelPertencente.add(painelComando);
        enviar.addActionListener(this);

    }

    /**
     * Método por criar os campos que vão o status do agente.
     */
    private void montarCampoPersonagem() {
        painelPersonagem.setPreferredSize(new Dimension(200, 500));
        painelPersonagem.setBorder(BorderFactory.createTitledBorder("Status"));
        painelPersonagem.setLayout(new BoxLayout(painelPersonagem, BoxLayout.Y_AXIS));
        montarPoder(painelPersonagem);
        montarVida(painelPersonagem);
        montarInimigo(painelPersonagem);
        janela.add(painelPersonagem, BorderLayout.EAST);
    }

    /**
     * Método que vai mostrar o poder do agente.
     * 
     * @param painelPertencente
     */
    private void montarPoder(JPanel painelPertencente) {
        campoPoder.setEditable(false);
        campoPoder.setText("Poder:");
        painelPertencente.add(campoPoder);
    }

    /**
     * Método que vai mostrar a vida do agente.
     * 
     * @param painelPertencente
     */
    private void montarVida(JPanel painelPertencente) {
        campoVida.setEditable(false);
        campoVida.setText("Vida:");
        painelPertencente.add(campoVida);
    }

    /**
     * Método que vai mostrar a quantidade de inimigos derrotados.
     * 
     * @param painelPertencente
     */
    private void montarInimigo(JPanel painelPertencente) {
        campoInimigos.setEditable(false);
        campoInimigos.setText("Inimigos Derrotados:");
        painelPertencente.add(campoInimigos);
    }

    /**
     * Método que irá mostrar a mensagem inicial do jogo na tela.
     */
    public void exibir() {
        janela.setVisible(true);
        exibirMensagem(imprimirBoasVindas() + imprimirLocalizacaoAtual() + imprimirSaidas());
    }

    /**
     * Método que irá exibir todas as mensagens presentes no jogo.
     * 
     * @param mensagem mensagens presentes no jogo.
     */
    public void exibirMensagem(String mensagem) {
        tela += mensagem;
        painelRespostas.setText(tela);
    }

    /**
     * Método que irá faz com que os dados sejam executados após o clicar do botão.
     */
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

    /**
     * Método que vai tratar os comandos digitados na tela.
     * 
     * @param comando
     */
    private void executar(String comando) {
        exibirMensagem(jogar(comando));
        atualizarStatus();
    }

    /**
     * Método que vai atualizar os campos de status do agente e a quantidade de
     * inimigos derrotados.
     */
    private void atualizarStatus() {
        int vida = pegarVidaAgente();
        int poder = pegarPoderAgente();
        int inimigos = pegarInimigosDerrotados();
        campoVida.setText("Vida:" + vida);
        campoPoder.setText("Poder:" + poder);
        campoInimigos.setText("Inimigos Derrotados: " + inimigos);
    }

}
