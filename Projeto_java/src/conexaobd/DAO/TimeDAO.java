/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import projeto.Jogador;
import projeto.Time;

/**
 *
 * @author Fernando
 */
public class TimeDAO extends ConnectionDAO{
    boolean sucesso = false;
    
    public boolean inserirTime(Time time) {
        connectToDB();
        String sql = "INSERT INTO Time (nomeTime) values(?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, time.nomeTime);
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
    
    public Time buscarTime(String nome) {
        
        connectToDB();
        Time timeAux = null;
        String sql = "select * from time where nomeTime = ?;";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                String aux = rs.getString("nomeTime");
                if(aux.isEmpty())
                {
                    sucesso = false;
                } else {
                    timeAux = new Time();
                    timeAux.nomeTime = rs.getString("nomeTime");

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
        return timeAux;
    }
    
}
