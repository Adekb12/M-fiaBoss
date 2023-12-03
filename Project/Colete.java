public class Colete extends Item{
    private int bonusVida;

    public Colete(String nome, int bonusVida){
        super(nome);
        this.bonusVida = bonusVida;
    }

    public int getBonusVida(){
        return bonusVida;
    }
}