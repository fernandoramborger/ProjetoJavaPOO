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
public class Time {
    //atributos
    
    public String nomeTime;
    
    Integrante[] jogadores = new  Integrante[2];
    Patrocinador[] patrocinios = new Patrocinador[2];
    
    
    
    //adicionar novo integrante no time
    public void addIntegrante(Integrante integrante){
        for (int i = 0; i < jogadores.length; i++) {
            if(jogadores[i] == null){
                jogadores[i] = integrante;
                break;
            }
        }
    }
    
    //adicionar novo patrocinio no time
    public void addPatrocinio(Patrocinador patrocinador){
        for (int i = 0; i < patrocinios.length; i++) {
            if(patrocinios[i] == null){
                patrocinios[i] = patrocinador;
                break;
            }
        }
    }
    
    //metodo para mostrar os integrantes do time
    public void listarIntegrantes(){
        System.out.println("Time: " + nomeTime);
        for (int i = 0; i < jogadores.length; i++) {
            if(jogadores[i] != null){
                jogadores[i].mostraInfo();
            }
        }
    }
    
    //adicionar novo integrante no time
    public int calculaPontuacao(){
        int pontuacaoTotal = 0;
        for (int i = 0; i < jogadores.length; i++) {
            if(jogadores[i] != null){
                pontuacaoTotal += jogadores[i].pontuacao;
            }
        }
        return pontuacaoTotal;
    }
    
    public void mostraPatrocinio(){
        for (int i = 0; i < patrocinios.length; i++) {
            if(patrocinios[i] != null){
                patrocinios[i].mostraInfo();
            }
        }
    }
    
}
