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
public class Patrocinador extends Time {
    //atributos
    public String marca;
    public float investimento;
    
    //método para mostrar informações do patrocínio
    public void mostraInfo(){
        System.out.println(marca);
        System.out.println("Investimento: " + investimento);
    }
}
