/**
 * Classe que representa todos os personagens envolvidos no jogo.
 * Sua função é definir a vida e a arma(poder) de cada personagem.
 * 
 * @author Luiz Victor Soriano
 */

public class Personagem {
    private Arma arma;
    private int pontosDeVida;

    public Personagem(int pontosDeVida, Arma arma) {
        this.arma = arma;
        this.pontosDeVida = pontosDeVida;
    }

    /**
     * Método que retorna a vida de um personagem.
     * 
     * @return int - pontos de vida do personagem.
     */
    public int getPontosDeVida() {
        return pontosDeVida;
    }

    /**
     * Método que retorna a arma de um personagem.
     * 
     * @return Arma - arma pertencente ao personagem.
     */
    public Arma getArma() {
        return arma;
    }

    /**
     * Método que diminui a vida de um personagem baseado do dano.
     * 
     * @param dano representa o poder que a arma possui.
     */
    public void levarDano(int dano) {
        pontosDeVida = pontosDeVida - dano;
    }

    /**
     * Método que calcula o poder da arma do personagem.
     * 
     * @return int - representa o poder da arma do personagem.
     */
    public int calculaPoder() {
        return arma.getPoder();
    }

    /**
     * Método que atualiza a vida do personagem.
     * 
     * @param bonusVida representa a vida que será adicionada.
     */

    public void receberBonusVida(int bonusVida) {
        pontosDeVida += bonusVida;
    }

}
