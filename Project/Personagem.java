public class Personagem {
    private Arma arma;
    private int pontosDeVida;

    public Personagem(int pontosDeVida, Arma arma){
        this.arma = arma;
        this.pontosDeVida = pontosDeVida;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public Arma getArma(){
        return arma;
    }
    
    public void levarDano(int dano) {
        pontosDeVida = pontosDeVida - dano;
    }

    public int calculaPoder() {
        return arma.getPoder();
    }

    public void receberBonusVida(int bonusVida){
        pontosDeVida += bonusVida;
    }
    
}
