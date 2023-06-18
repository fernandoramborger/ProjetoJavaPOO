/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author Fernando
 */
public class Integrante extends Time {
    //atributos de integrante do time
    public String nick;
    public String posicao;
    public int pontuacao;
    
    //métodos
    
    //mostrar informações do Integrante
    public void mostraInfo(){
        System.out.println(nick);
        System.out.println("Posição: " + posicao);
        System.out.println("Pontuação: " + pontuacao);
    }
    
}
