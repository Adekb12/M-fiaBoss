public class Inimigo {
    private int pontosDeVida;
    private Item item;

    public Inimigo(int pontosDeVida, Item item){
        this.pontosDeVida = pontosDeVida;
        this.item = item;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    private Item getItem() {
        return item;
    }
    
}

