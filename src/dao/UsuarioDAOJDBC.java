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
    
    @Override
    public  Usuario consultarLogin(String user, String password){
        
        Usuario usuarioProcurado = null;
        String consulta = "SELECT idUsuario, TipoUsuario, Login, Senha FROM usuario WHERE Login = ? AND Senha = ?";
       
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, user);
            stmt.setString(2, password);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                usuarioProcurado = new Usuario();
                
                usuarioProcurado.setIdUser(resultado.getInt("idUsuario"));
                usuarioProcurado.setTipo(resultado.getInt("TipoUsuario"));
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

    @Override
    public Usuario buscarUsuario(int idUser) {
            Usuario usuarioProcurado = null;
        String consulta = "SELECT * FROM Usuario WHERE idUsuario = ?";
       try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1,idUser);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                usuarioProcurado = new Usuario();
                
                usuarioProcurado.setIdUser(resultado.getInt("idUsuario"));
                usuarioProcurado.setTipo(resultado.getInt("TipoUsuario"));
                usuarioProcurado.setLogin(resultado.getString("Login"));
                usuarioProcurado.setSenha(resultado.getString("Senha"));
                usuarioProcurado.setEmail(resultado.getString("Email"));
                usuarioProcurado.setMatricula(resultado.getString("Matricula"));
                usuarioProcurado.setDataNascimento(resultado.getString("DataNascimento"));
                usuarioProcurado.setTelefone(resultado.getString("Telefone"));
                usuarioProcurado.setNome(resultado.getString("Nome"));
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