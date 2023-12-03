import java.util.Random;

public class Chefe extends Personagem{
    private double sorte;

    public Chefe(int pontosDeVida, Arma arma) {
        super(pontosDeVida, arma);
        this.sorte = calcularSorte();
    }

    private double calcularSorte() {
        Random random = new Random();
        return random.nextDouble();
    }

    public double getSorte() {
        return sorte;
    }
}