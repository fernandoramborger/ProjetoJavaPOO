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
public class Treinador extends Integrante {
    //atributos
    public int idade;
    public int titulos;
    
    //métodos
    //mostrar informações do treinador
    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Idade: " + idade);
        System.out.println("Quantidade de títulos: " + titulos);
        System.out.println("");
    }
}
