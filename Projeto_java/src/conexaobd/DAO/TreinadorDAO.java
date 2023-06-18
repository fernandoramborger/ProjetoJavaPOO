/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobd.DAO;

import java.sql.SQLException;
import projeto.Jogador;
import projeto.Treinador;

/**
 *
 * @author Fernando
 */
public class TreinadorDAO extends ConnectionDAO {
    boolean sucesso = false;
    
    public boolean inserirTreinador(Treinador treinador) {
        connectToDB();
        String sql = "INSERT INTO Treinador (idade, titulos, Integrante_nick) values(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, treinador.idade);
            pst.setInt(2, treinador.titulos);
            pst.setString(3, treinador.nick);
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
    
    public Treinador buscarTreinadorPorId(String nick) {
        
        connectToDB();
        Treinador treinadorAux = null;
        String sql = "select * from treinador where Integrante_nick = ?;";
        
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
                    treinadorAux = new Treinador();
                    treinadorAux.nick = rs.getString("Integrante_nick");
                    treinadorAux.idade = rs.getInt("idade");
                    treinadorAux.titulos = rs.getInt("titulos");
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
        return treinadorAux;
    }
}
