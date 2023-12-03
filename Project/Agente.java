//Feito por Gabriel
public class Agente extends Personagem {
    private Colete colete;

    public Agente(int pontosDeVida, Arma arma) {
        super(pontosDeVida, arma);
    }

    public void setColete(Colete novoColete){
        colete = novoColete;
        super.receberBonusVida(colete.getBonusVida());
    }

    public void aumentarPoder(int poder){
        getArma().setPoder(poder);
    }
}
