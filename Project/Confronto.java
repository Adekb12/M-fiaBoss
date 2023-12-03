//Feita por Gabriel
public class Confronto{

    public static void darDanoCapanga(Agente agente, Capanga capanga){
        int poder = agente.calculaPoder();
        capanga.levarDano(poder);
    }

    public static void darDanoCapangaAgente(Agente agente, Capanga capanga){
        int poder = capanga.calculaPoder();
        int nivelDeConfianca = capanga.getNivelDeConfianca();
        agente.levarDano(poder*(1 + nivelDeConfianca/10));
    }

    public static int simularConfronto(Agente agente, Chefe chefe){
        double chanceA = chefe.getPontosDeVida()/agente.calculaPoder();
        double chanceC = agente.getPontosDeVida()/chefe.calculaPoder();
        if(chanceA < chanceC){
            return 1;
        }else if((chanceC - chanceA)<1){
            return 0;
        }
        return -1;
    }

    public static void darDanoChefe(Agente agente, Chefe chefe){
        int poder = agente.calculaPoder();
        chefe.levarDano((int)(poder*(1 + (1 - chefe.getSorte())/20)));
    }

    public static void darDanoChefeAgente(Agente agente, Chefe chefe){
        int poder = chefe.calculaPoder();
        agente.levarDano((int)(poder*(1 + chefe.getSorte())/30));
    }
}