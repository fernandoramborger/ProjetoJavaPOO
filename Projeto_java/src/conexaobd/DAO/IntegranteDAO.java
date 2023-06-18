/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import projeto.Integrante;
import projeto.Jogador;
import projeto.Time;

/**
 *
 * @author Fernando
 */
public class IntegranteDAO extends ConnectionDAO {
    boolean sucesso = false;
    
    public boolean inserirIntegrante(Integrante integrante, Time time) {
        connectToDB();
        String sql = "INSERT INTO Integrante (Time_nomeTime, nick, posicao, pontuacao) values(?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, time.nomeTime);
            pst.setString(2, integrante.nick);
            pst.setString(3, integrante.posicao);
            pst.setInt(4, integrante.pontuacao);

            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        
        return sucesso;
    }
    
    public Integrante buscarIntegrantePorId(String time) {
        
        connectToDB();
        Integrante integranteAux = null;
        String sql = "select * from integrante where Time_nomeTime = ?;";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, time);
            rs = pst.executeQuery();
            while (rs.next()) {
                String aux = rs.getString("nick");
                if(aux.isEmpty())
                {
                    sucesso = false;
                } else {
                    integranteAux = new Integrante();
                    integranteAux.nick = rs.getString("nick");
                    integranteAux.posicao = rs.getString("posicao");
                    integranteAux.pontuacao = rs.getInt("pontuacao");
                }
            }
            sucesso = true;
        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return integranteAux;
    }
    
    public boolean atualizarIntegrante(String nick, Integrante integrante) {
        connectToDB();
        String sql = "UPDATE Integrante SET nick=? where nick=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, integrante.nick);
            pst.setString(2, nick);
            pst.execute();
            sucesso = true;
            
        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    
    public ArrayList<Integrante> buscarIntegrante(String time) {
        ArrayList<Integrante> listaDeIntegrantes = new ArrayList<>();
        
        connectToDB();
        
        String sql = "SELECT * FROM Integrante where Time_nomeTime=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, time);
            rs = pst.executeQuery();
            System.out.println("Lista de Pessoas: ");
            while (rs.next()) {
                Integrante integranteAux = new Integrante();
                integranteAux.nick = rs.getString("nick");
                integranteAux.posicao = rs.getString("posicao");
                integranteAux.nomeTime = rs.getString("Time_nomeTime");
                integranteAux.pontuacao = rs.getInt("pontuacao");

                listaDeIntegrantes.add(integranteAux);
            }
            sucesso = true;
        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return listaDeIntegrantes;
    }
}
