import java.util.Random;

public class Chefe extends Personagem{
    private double chanceDeDormir;

    public Chefe(int pontosDeVida, Arma arma) {
        super(pontosDeVida, arma);
        this.chanceDeDormir = calcularChanceDeDormir();
    }

    private double calcularChanceDeDormir() {
        Random random = new Random();
        return random.nextDouble();
    }

    public double getChanceDeDormir() {
        return chanceDeDormir;
    }
}