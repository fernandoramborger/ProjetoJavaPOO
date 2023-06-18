/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobd.DAO;

import java.sql.SQLException;
import projeto.Integrante;
import projeto.Jogador;

/**
 *
 * @author Fernando
 */
public class JogadorDAO extends ConnectionDAO {
    boolean sucesso = false;
    
    public boolean inserirJogador(Jogador jogador) {
        connectToDB();
        String sql = "INSERT INTO Jogador (elo, winr, win, lose, Integrante_nick) values(?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.elo);
            pst.setString(2, jogador.winr);
            pst.setString(3, jogador.win);
            pst.setString(4, jogador.lose);
            pst.setString(5, jogador.nick);
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
    
    public Jogador buscarJogadorPorId(String nick) {
        
        connectToDB();
        Jogador jogadorAux = null;
        String sql = "select * from jogador where Integrante_nick = ?;";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nick);
            rs = pst.executeQuery();
            while (rs.next()) {
                String aux = rs.getString("Integrante_nick");
                if(aux.isEmpty())
                {
                    sucesso = false;
                } else {
                    jogadorAux = new Jogador();
                    jogadorAux.nick = rs.getString("Integrante_nick");
                    jogadorAux.elo = rs.getString("elo");
                    jogadorAux.winr = rs.getString("winr");
                    jogadorAux.win = rs.getString("win");
                    jogadorAux.lose = rs.getString("lose");
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
        return jogadorAux;
    }
    
    public boolean atualizarJogador(String nick, Jogador jogador) {
        connectToDB();
        String sql = "UPDATE Jogador SET elo=?, winr=?, win=?, lose=? where Integrante_nick=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.elo);
            pst.setString(2, jogador.winr);
            pst.setString(3, jogador.win);
            pst.setString(4, jogador.lose);
            pst.setString(5, jogador.nick);
            pst.setString(6, nick);
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
    
    public boolean deletarJogador(String nick) {
        connectToDB();
        String sql = "DELETE FROM Jogador where Integrante_nick=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nick);
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
}
