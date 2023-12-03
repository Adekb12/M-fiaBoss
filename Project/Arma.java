public class Arma extends Item{
    private int poder;

    public Arma(String nome, int poder){
        super(nome);
        this.poder = poder;
    }

    public int getPoder(){
        return poder;
    }
    public int setPoder(int dano){
        poder += dano;
        return poder;
    }
}