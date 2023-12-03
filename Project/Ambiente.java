/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe eh parte da aplicacao "World of Zuul".
 * "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localizacao no cenario do jogo. Ele eh
 * conectado aos outros ambientes atraves de saidas. As saidas sao
 * nomeadas como norte, sul, leste e oeste. Para cada direcao, o ambiente
 * guarda uma referencia para o ambiente vizinho, ou null se nao ha
 * saida naquela direcao.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido por Julio Cesar Alves)
 * @version 2011.07.31 (2016.02.01)
 */
import java.util.HashMap;
public class Ambiente 
{
    private String nome;
    private String descricao;
    private HashMap<String, Ambiente> saidas;
    private Personagem inimigo;
    private Item colete;

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma cozinha" ou
     * "
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "um jardim aberto".
     * @param descricao A descricao do ambiente.
     */
    public Ambiente(String nome, String descricao) 
    {
        this.nome = nome;
        this.descricao = descricao;
        saidas = new HashMap<String, Ambiente>(); 
        inimigo = null; 
        colete = null;
    }

    public String getNome(){
        return nome;
    }

    public void setInimigo(Personagem inimigo){
        this.inimigo = inimigo;
    }

    public void setColete(Item colete){
        this.colete = colete;
    }
    public Personagem getInimigo(){
        return inimigo;
    }

    public Item getColete(){
        return colete;
    }

    public void removerInimigo(){
        inimigo = null;
    }

    public void removerColete(){
        colete = null;
    }
    /**
     * Define as saidas do ambiente. Cada direcao ou leva a um
     * outro ambiente ou eh null (nenhuma saida para la).
     * @param norte A saida norte.
     * @param leste A saida leste.
     * @param sul A saida sul.
     * @param oeste A saida oeste.
     * @param noroeste
     * @param sudestes
     */
    public void ajustarSaidas(String direcao, Ambiente ambiente) 
    {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descricao do ambiente.
     */
    public String getDescricao()
    {
        return descricao;
    }

    public Ambiente getAmbiente(String direcao){
        return saidas.get(direcao);
    }

    public String direcoesDeSaida() {
        String textoSaidas = "| ";
        for (String direcao : saidas.keySet()) {
            if(getAmbiente(direcao) != null)
                textoSaidas = textoSaidas + getAmbiente(direcao).getNome() + " | ";
        }
        return textoSaidas;
    }


}
