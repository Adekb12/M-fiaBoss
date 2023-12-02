import java.util.Random;

public class Capanga extends Personagem{
    private int nivelDeConfianca;

    public Capanga(int pontosDeVida, Arma arma){
        super(pontosDeVida, arma);
        this.nivelDeConfianca = calcularNivelDeConfianca();
    }

    private int calcularNivelDeConfianca() {
        Random random = new Random();
        return random.nextInt(5);
    }

    public int getNivelDeConfianca() {
        return nivelDeConfianca;
    }
}