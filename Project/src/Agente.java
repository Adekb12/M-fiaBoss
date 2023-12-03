/**
 * Classe que representa o agente, o personagem principal do jogo.
 * Sua função é atualizar o status de vida, atráves do método setColete, e o seu
 * poder, com o método aumentarPoder.
 * 
 * @author Luiz Victor Soriano
 */
public class Agente extends Personagem {
    private Colete colete;

    public Agente(int pontosDeVida, Arma arma) {
        super(pontosDeVida, arma);
    }

    /**
     * Método para atualizar o colete equipado pelo agente, aumentando seu vida.
     * 
     * @param novoColete atributo que representa o colete achado em um cômodo.
     */
    public void setColete(Colete novoColete) {
        colete = novoColete;
        super.receberBonusVida(colete.getBonusVida());
    }

    /**
     * Método para atualizar o status de poder do agente
     * 
     * @param poder atributo que representa o poder da arma coletada do inimigo.
     */
    public void aumentarPoder(int poder) {
        getArma().setPoder(poder);
    }
}
