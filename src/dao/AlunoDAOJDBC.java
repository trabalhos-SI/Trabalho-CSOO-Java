/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import modelo.Aluno;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class AlunoDAOJDBC extends DAOBaseJDBC implements AlunoDAO {
    
    @Override
    public Aluno consultarLogin(String loginUser, String loginPass){
        
        Aluno alunoLido = null;
        String consulta = 
        "SELECT idAaluno, nome, matricula, nascimento, email, telefone FROM Aluno WHERE user = ? AND password = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, loginUser);
            stmt.setString(2, loginPass);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                alunoLido = new Aluno();
                alunoLido.setIdAluno(resultado.getInt("idAluno"));
                alunoLido.setNome(resultado.getString("nome"));
                alunoLido.setMatricula(resultado.getInt("matricula"));
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                alunoLido.setNascimento(resultado.getString(fmt.format("nascimento")));
                alunoLido.setEmail(resultado.getString("email"));
                alunoLido.setTelefone(resultado.getString("telefone"));
                stmt.close();
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuário Não encontrado");
                return null;
            }
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e.getMessage());
        }
        
        return alunoLido;
    }
    
}
