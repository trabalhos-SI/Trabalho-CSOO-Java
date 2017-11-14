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
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class AlunoDAOJDBC extends DAOBaseJDBC implements AlunoDAO {
    
    public static int idGeral;
    
    
    @Override
    public Aluno consultarLogin(String loginUser, String loginPass){
        
        Aluno alunoLido = null;
        String consulta = 
        "SELECT idAluno, nome, matricula, nascimento, email, telefone, tipo, user, pass FROM aluno WHERE user = ? AND pass = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, loginUser);
            stmt.setString(2, loginPass);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                alunoLido = new Aluno();
//                alunoLido.setIdAluno(resultado.getInt("idAluno"));
//                alunoLido.setNome(resultado.getString("nome"));
//                alunoLido.setMatricula(resultado.getInt("matricula"));
//                //SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
//                alunoLido.setNascimento(resultado.getString("nascimento"));
//                alunoLido.setEmail(resultado.getString("email"));
//                alunoLido.setTelefone(resultado.getString("telefone"));
//                alunoLido.setTipo(resultado.getString("tipo"));
//                alunoLido.setUsuario(resultado.getString("user"));
//                alunoLido.setSenha(resultado.getString("pass"));
                stmt.close();
                
            }else{
                //JOptionPane.showMessageDialog(null, "Usuário Não encontrado");
                return null;
            }
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e.getMessage());
        }
        
//        idGeral = alunoLido.getIdAluno();
        
        return alunoLido;
    }
    
       
}
