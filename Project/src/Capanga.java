import java.util.Random;

/**
 * Classe que representa o capanga, o inimigo básico do jogo.
 * Sua função é determinar o nível de confiança do capanga, que determina um
 * adicional de dano que ele causa.
 * 
 * @author Mardem Arantes
 */
public class Capanga extends Personagem {
    private int nivelDeConfianca;

    public Capanga(int pontosDeVida, Arma arma) {
        super(pontosDeVida, arma);
        this.nivelDeConfianca = calcularNivelDeConfianca();
    }

    /**
     * Método que calcula de forma aleatória o nível de confiança
     * 
     * @return int - o nível de confiança aleatório.
     */
    private int calcularNivelDeConfianca() {
        Random random = new Random();
        return random.nextInt(5);
    }

    /**
     * Método que retorna o nível de confiança.
     * 
     * @return int - o nível de confiança a ter usado no cálculo da classe
     *         Confronto.
     */
    public int getNivelDeConfianca() {
        return nivelDeConfianca;
    }
}