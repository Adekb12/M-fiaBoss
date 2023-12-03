// feito por Bruno
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface implements ActionListener {
    private JFrame janela;
    private ImageIcon mapa;
    private JLabel exibirMapa;
    private JTextField campoEntradaDados; // para conseguir entrar com os comandos
    private String tela;
    private JPanel painelSuperior;
    private JPanel painelInferior;
    private JTextField painelRespostas;
    private JPanel painelComando;
    private JPanel painelPersonagem;
    private JButton enviar;
    private JTextField campoVida;
    private JTextField campoPoder;

    public Interface() {
        mapa = new ImageIcon("/home/bruno/Documents/mapaRosa.jpg");// pega o caminho do arquivo de imagem
        janela = new JFrame("Mapa");// aparece mapa no topo da tela
        painelSuperior = new JPanel();
        painelInferior = new JPanel();
        painelRespostas = new JTextField();
        painelComando = new JPanel();
        painelPersonagem = new JPanel();
        enviar = new JButton("Enviar resposta");
        campoVida = new JTextField();
        campoPoder = new JTextField();

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
        painelSuperior.setPreferredSize(new Dimension(mapa.getIconWidth(), mapa.getIconHeight()));
        painelSuperior.setBorder(BorderFactory.createTitledBorder("Planta da casa dos mafiosos"));
        exibirMapa = new JLabel(mapa);// adiciona em uma label
        painelSuperior.add(exibirMapa);// adiciona na janela na posicao norte

        janela.add(painelSuperior, BorderLayout.NORTH);

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

        painelPertecente.add(painelRespostas);
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
        campoPoder.setEditable(false);
        campoVida.setEditable(false);
        painelPersonagem.add(campoVida);
        painelPersonagem.add(campoPoder);
        janela.add(painelPersonagem, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = campoEntradaDados.getText();
        campoEntradaDados.setText("");
        tela = " ";
        executar(comando);
    }

    private void executar(String comando) {
        int vida = 10;
        int poder = 10;
        if (comando.equals("Irnorte ")) {
            tela += "Voce esta no a, deseja ir para o lado b ou continuar no a";
            painelRespostas.setText(tela);
        } else if (comando.equals("b")) {
            tela += "Voce esta no lado b, deseja ir para o lado a ou continuar no b";
            painelRespostas.setText(tela);
        } else {
            tela += "comando invalido, entre com um comando valido";
            painelRespostas.setText(tela);
        }
        campoVida.setText("Vida:" + vida);
        campoPoder.setText("Poder:" + poder);
    }

    public void exibir() {
        janela.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Interface i = new Interface();
        i.exibir();

    }
}


