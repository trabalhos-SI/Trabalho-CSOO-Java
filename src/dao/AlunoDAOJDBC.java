/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Endereco;
import modelo.Usuario;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class AlunoDAOJDBC extends DAOBaseJDBC implements AlunoDAO {
    
    public static Aluno aluno;
    
    @Override
    public Aluno buscarAluno(Usuario usuario){
        
//        aluno.setLogin(usuario.getLogin());
//        aluno.setSenha(usuario.getSenha());
        
        Aluno alunoProcurado = null;
        String consulta = "SELECT Usuario.Nome, Usuario.Email, Usuario.Matricula, Usuario.DataNascimento,"
                + " Aluno.idAluno, Aluno.Curso, Endereco.idEndereco, Endereco.Rua, Endereco.Bairro,"
                + " Endereco.Cidade, Endereco.Estado"
                + " FROM Usuario INNER JOIN Aluno"
                + " ON Usuario.idUsuario = Aluno.Usuario_idUsuario"
                + " INNER JOIN Endereco ON Endereco.idEndereco = Aluno.Endereco_idEndereco"
                + " WHERE Login = ? AND Senha = ? ";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                alunoProcurado = new Aluno();
                alunoProcurado.setLogin(usuario.getLogin());
                alunoProcurado.setSenha(usuario.getSenha());
                alunoProcurado.setIdAluno(resultado.getInt("idAluno"));
                alunoProcurado.setNome(resultado.getString("Nome"));
                alunoProcurado.setEmail(resultado.getString("Email"));
                alunoProcurado.setMatricula(resultado.getString("Matricula"));
                alunoProcurado.setDataNascimento(resultado.getString("DataNascimento"));
                alunoProcurado.setLogin(resultado.getString("Login"));
                alunoProcurado.setSenha(resultado.getString("Senha"));
                alunoProcurado.setCurso(resultado.getString("Curso"));
                
                Endereco dadosEndereco = new Endereco();
                
                dadosEndereco.setIdEndereco(resultado.getInt("idEndereco"));
                dadosEndereco.setRua(resultado.getString("Rua"));
                dadosEndereco.setBairro(resultado.getString("Bairro"));
                dadosEndereco.setCidade(resultado.getString("Cidade"));
                dadosEndereco.setEstado(resultado.getString("Estado"));
                
                                
                alunoProcurado.setEndereco(dadosEndereco);
                
                
            }else{
                return null;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: - " + e.getMessage());
            
        }
        
        return alunoProcurado;
    }
    
    
       
}
