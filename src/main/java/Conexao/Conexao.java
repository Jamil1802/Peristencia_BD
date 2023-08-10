package Conexao;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {

    public static Connection getConexao(){
        Connection con=null;
        try{
           con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/universidade","root","");
            System.out.println("Conectado com sucesso!");
            }catch (SQLException e ){
                System.out.println("Erro ao Conectar com a base de Dados");
                System.out.println(e);
            }
        return con;
    }
    public static void main (String []args){
      Conexao.getConexao();
    }  
}
