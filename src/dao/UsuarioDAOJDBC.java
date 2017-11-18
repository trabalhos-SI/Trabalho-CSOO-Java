/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Usuario;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class UsuarioDAOJDBC extends DAOBaseJDBC implements UsuarioDAO {
    
    public static Usuario usuario;
    
    @Override
    public  Usuario consultarLogin(String user, String password){
        
        Usuario usuarioProcurado = null;
        String consulta = "SELECT idUsuario, tipo, Login, Senha FROM usuario WHERE Login = ? AND Senha = ?";
       
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, user);
            stmt.setString(2, password);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                usuarioProcurado = new Usuario();
                
                usuarioProcurado.setIdUser(resultado.getInt("idUsuario"));
                usuarioProcurado.setTipo(resultado.getString("tipo"));
                usuarioProcurado.setLogin(resultado.getString("Login"));
                usuarioProcurado.setSenha(resultado.getString("Senha"));
                stmt.close();
            }else{
                return null;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: - " + e.getMessage());
        }
   
       
        return usuarioProcurado;
    }



}