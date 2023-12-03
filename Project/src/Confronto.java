/**
 * Classe que representa os confrontos entre o agentes e os demais personagens.
 * 
 * @author Gabriel Furtado
 */
public class Confronto {

    /**
     * Método que irá computar o dano que o agente irá dar ao capanga.
     * 
     * @param agente  objeto que representa o agente.
     * @param capanga objeto que representa o capanga.
     */
    public static void darDanoCapanga(Agente agente, Capanga capanga) {
        int poder = agente.calculaPoder();
        capanga.levarDano(poder);
    }

    /**
     * Método que irá computar o dano que o capanga irá dar no agente, baseado no
     * seu nível de confiança.
     * 
     * @param agente  objeto que representa o agente.
     * @param capanga objeto que representa o capanga.
     */
    public static void darDanoCapangaAgente(Agente agente, Capanga capanga) {
        int poder = capanga.calculaPoder();
        int nivelDeConfianca = capanga.getNivelDeConfianca();
        agente.levarDano(poder * (1 + nivelDeConfianca / 10));
    }

    /**
     * Método que irá simular um confronto entre o agente e o chefe para obter as
     * chances de vitória.
     * 
     * @param agente objeto que representa o agente.
     * @param chefe  objeto que representa o chefe.
     * @return int - representar a chance do agente contra o chefe.
     */
    public static int simularConfronto(Agente agente, Chefe chefe) {
        double chanceA = chefe.getPontosDeVida() / agente.calculaPoder();
        double chanceC = agente.getPontosDeVida() / chefe.calculaPoder();
        if (chanceA < chanceC) {
            return 1;
        } else if ((chanceC - chanceA) < 1) {
            return 0;
        }
        return -1;
    }

    /**
     * Método que irá computar o dano que o chefe levará.
     * 
     * @param agente objeto que representa o agente.
     * @param chefe  objeto que representa o chefe.
     */
    public static void darDanoChefe(Agente agente, Chefe chefe) {
        int poder = agente.calculaPoder();
        chefe.levarDano((int) (poder * (1 + (1 - chefe.getSorte()) / 20)));
    }

    /**
     * Método que irá computar o dano que o chefe dará ao agente.
     * @param agente  objeto que representa o agente.
     * @param capanga objeto que representa o capanga.
     */
    public static void darDanoChefeAgente(Agente agente, Chefe chefe) {
        int poder = chefe.calculaPoder();
        agente.levarDano((int) (poder * (1 + chefe.getSorte()) / 30));
    }
}