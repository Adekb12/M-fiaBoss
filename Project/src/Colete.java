/**
 * Classe que representa o colete, que adicionará pontos de vida.
 * 
 * @author Gabriel Furtado
 */
public class Colete extends Item {
    private int bonusVida;

    public Colete(String nome, int bonusVida) {
        super(nome);
        this.bonusVida = bonusVida;
    }

    /**
     * Método que retorna o bônus de vida do colete.
     * 
     * @return int - bônus de vida do colete.
     */
    public int getBonusVida() {
        return bonusVida;
    }
}