/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class Jogador extends Integrante implements Treinar {
    //atributos
    public String elo; // ranking no jogo
    public String winr; // porcentagem de vitórias do jogador
    public String win; // número de vitórias do jogador
    public String lose; // número de derrotas do jogador
    
    JFrame TelaInfoJogador;
    
    //métodos
    
    //mostrar informações do jogador
    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Elo: " + elo);
        System.out.println("Win Ratio: " + winr);
        System.out.println("Vitórias: " + win);
        System.out.println("Derrotas: " + lose);
        System.out.println("");
    }
    
    //método para treino
    @Override
    public void jogar() {
        JOptionPane.showMessageDialog(TelaInfoJogador, nick + " está online nas filas rankeadas!");
    }
    
    
}
