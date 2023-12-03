
/**
 * Classe que representa o chefe do jogo.
 * Sua função é definir a sorte do chefe, que irá determinar se ele receberá muito dano(baixa sorte) ou pouco dano(muita sorte).
 * @author Mardem Arantes
 */
import java.util.Random;

public class Chefe extends Personagem {
    private double sorte;

    public Chefe(int pontosDeVida, Arma arma) {
        super(pontosDeVida, arma);
        this.sorte = calcularSorte();
    }

    /**
     * Método que calcula a sorte do chefe.
     * 
     * @return double - retorna o valor da sorte.
     */
    private double calcularSorte() {
        Random random = new Random();
        return random.nextDouble();
    }

    /**
     * Método que retorna a sorte.
     * 
     * @return int- sorte.
     */
    public double getSorte() {
        return sorte;
    }
}