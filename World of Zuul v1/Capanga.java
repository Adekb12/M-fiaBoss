import java.util.Random;

public class Capanga extends Inimigo{
    private int nivelDeConfianca;

    public Capanga(int pontosDeVida, Item item){
        super(pontosDeVida, item);
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