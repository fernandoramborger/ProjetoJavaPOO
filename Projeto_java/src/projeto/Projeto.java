/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import conexaobd.DAO.TimeDAO;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Fernando
 */
public class Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        
        Time t1 = new Time();
        t1.nomeTime = "Inatel";
        
        Jogador j1 = new Jogador();
        j1.nick = "joão";
        String pesquisa = j1.nick.replaceAll("\\s+","");
        
        Document doc = (Document) Jsoup.connect("https://br.op.gg/summoner/userName=" + pesquisa)
                .timeout(6000).get();
        Elements rank = doc.select("div.TierRank");
        Elements winr = doc.select("div.TierInfo");
        System.out.println(rank.select("div").text());
        System.out.println(winr.select("span.winratio").text());
        System.out.println(winr.select("span.wins").text());
        System.out.println(winr.select("span.losses").text());
        
        j1.elo = rank.select("div").text();
        j1.winr = winr.select("span.winratio").text();
        j1.win = winr.select("span.wins").text();
        j1.lose = winr.select("span.losses").text();
        
        
        
        j1.pontuacao = 100;
        j1.posicao = "Atirador";
        t1.addIntegrante(j1);
        
        Treinador c1 = new Treinador();
        c1.posicao = "Treinador";
        c1.nick = "Dudu";
        c1.idade = 22;
        c1.pontuacao = 100;
        c1.titulos = 20;
        t1.addIntegrante(c1);
        System.out.println("Pontuação Total do time: " + t1.calculaPontuacao());
        
        Patrocinador p1 = new Patrocinador();
        p1.investimento = 1000000.0f;
        p1.marca = "Coca-Cola";
        t1.addPatrocinio(p1);
        
        Patrocinador p2 = new Patrocinador();
        p2.investimento = 2000000.0f;
        p2.marca = "Monstro";
        t1.addPatrocinio(p2);
        
        t1.listarIntegrantes();
        t1.mostraPatrocinio();
        
        j1.jogar();
        
        TimeDAO tDAO = new TimeDAO();
        if(tDAO.inserirTime(t1)){
            System.out.println("Consegui inserir");
        }
        else{
            System.out.println("Não foi dessa vez");
        }
    }
    
}
