import java.util.Random;

public class Chefe extends Inimigo{
    private double chanceDeDormir;

    public Chefe(int pontosDeVida, Item item) {
        super(pontosDeVida, item);
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