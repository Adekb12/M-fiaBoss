/**
 * Classe que representa a arma que um personagem irá possuir.
 * Sua função é definir o poder da arma e atualizar o poder de uma arma.
 * 
 * @author Bruno Firmino
 */
public class Arma extends Item {
    private int poder;

    public Arma(String nome, int poder) {
        super(nome);
        this.poder = poder;
    }

    /**
     * Método que retorna o poder da arma.
     * 
     * @return int - poder da arma do personagem.
     */
    public int getPoder() {
        return poder;
    }

    /**
     * Método que atualiza o poder de uma arma, dado o dano da arma recebido.
     * 
     * @param dano inteiro que representa o dano que uma arma inflinge.
     * @return int - novo poder da arma.
     */
    public int setPoder(int dano) {
        poder += dano;
        return poder;
    }
}