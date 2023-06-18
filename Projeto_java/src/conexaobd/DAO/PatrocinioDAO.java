/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobd.DAO;

import java.sql.SQLException;
import projeto.Jogador;
import projeto.Patrocinador;
import projeto.Treinador;

/**
 *
 * @author Fernando
 */
public class PatrocinioDAO extends ConnectionDAO {
    boolean sucesso = false;
    
    public boolean inserirPatrocinador(Patrocinador patrocinador) {
        connectToDB();
        String sql = "INSERT INTO Patrocionio (marca, investimento) values(?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, patrocinador.marca);
            pst.setFloat(2, patrocinador.investimento);
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
    
    public boolean atualizarPatrocinador(String marca, Patrocinador patrocinador) {
        connectToDB();
        String sql = "UPDATE patrocionio SET investimento=? where marca=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, patrocinador.investimento);
            pst.setString(2, marca);
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
