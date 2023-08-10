/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanio Anibal Macamo
 */
public class EstudanteDAO {
    private Connection con = null;
    
    public EstudanteDAO(){
           con = ConnectionFactory.getConnection();
    }
    
    public boolean guardar(Estudante estudante){
        String sql = "INSERT INTO estudante (nrMatricula,nome,apelido,contacto,endereco) VALUES (?,?,?,?,?)";
                
        PreparedStatement stmt = null;
        
         try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, estudante.getNrMatricula());
            stmt.setString(2, estudante.getNome());
            stmt.setString(3, estudante.getApelido());
            stmt.setString(4, estudante.getContacto());
            stmt.setString(5, estudante.getEndereco());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public ArrayList<Estudante> listaEstudantes(){
        String sql = "SELECT * FROM estudante";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Estudante> listaEstudantes= new ArrayList<>();
        
         try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Estudante estudante = new  Estudante(); 
                estudante.setNrMatricula(rs.getInt("nrMatricula"));
                estudante.setNome(rs.getString("nome"));
                estudante.setApelido(rs.getString("apelido"));
                estudante.setContacto(rs.getString("contacto"));
                estudante.setEndereco(rs.getString("endereco"));
                listaEstudantes.add(estudante);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ ex);
             JOptionPane.showMessageDialog(null,"Problemas com a Base de Dados"+ ex);
        }
        return listaEstudantes;
    }
     public boolean Actualizar(Estudante estudante){
       String sql = "UPDATE estudante SET nome= ?, apelido=?, contacto=?, endereco=? WHERE nrMatricula= ?";
        PreparedStatement stmt = null;
        
        try {
                stmt = con.prepareStatement(sql);
                stmt.setString(1, estudante.getNome());
                stmt.setString(2, estudante.getApelido());
                stmt.setString(3, estudante.getContacto());
                stmt.setString(4, estudante.getEndereco());
                stmt.setInt(5, estudante.getNrMatricula());   
                stmt.executeUpdate();
                return true;
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERRO COM BASE DE DADOS!"+ex);
            return false;
        }
   }
  
    public boolean Remover(int nrMatricula){
       
        String sql = "DELETE FROM estudante WHERE nrMatricula = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt( 1, nrMatricula);
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
}
