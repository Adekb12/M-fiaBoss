/**
 * Classe que representa os itens presentes no jogo.
 * @author Bruno Firmino
 */

public class Item{
    private String nome;

    public Item(String nome){
        this.nome = nome;
    }
/**
 * Método que retorna o nome do item.
 * @return String - o nome do item.
 */
    public String getNome(){
        return nome;
    }
}