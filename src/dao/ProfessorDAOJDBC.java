/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import modelo.AlunoHasDisciplina;
import modelo.Disciplina;
import modelo.Endereco;
import modelo.Professor;
import modelo.Usuario;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class ProfessorDAOJDBC extends DAOBaseJDBC implements ProfessorDAO {
    
    @Override
    public Professor buscarProfessor(Usuario usuario){
        
        Professor professorProcuraro = null;
        String consulta = "SELECT *"
                + " FROM usuario INNER JOIN professor"
                + " ON usuario.idUsuario = professor.idUsuario"
                + " INNER JOIN endereco ON endereco.idEndereco = professor.idEndereco"
                + " WHERE professor.idUsuario = ?";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, usuario.getIdUser());
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                professorProcuraro = new Professor();
                professorProcuraro.setIdProfessor(resultado.getInt("idProfessor"));
                professorProcuraro.setTitulo(resultado.getString("Titulo"));
                professorProcuraro.setFormacao(resultado.getString("Formacao"));
                
                Endereco dadosEndereco = new Endereco();
                
                dadosEndereco.setIdEndereco(resultado.getInt("idEndereco"));
                dadosEndereco.setRua(resultado.getString("Rua"));;
                dadosEndereco.setBairro(resultado.getString("Bairro"));
                dadosEndereco.setCidade(resultado.getString("Cidade"));
                dadosEndereco.setEstado(resultado.getString("Estado"));
                
                Usuario dadoUsuario = new Usuario();
                
                dadoUsuario.setDataNascimento(resultado.getString("DataNascimento"));
                dadoUsuario.setLogin(resultado.getString("Login"));
                dadoUsuario.setEmail(resultado.getString("Email"));
                dadoUsuario.setIdUser(resultado.getInt("idUsuario"));
                dadoUsuario.setMatricula(resultado.getString("Matricula"));
                dadoUsuario.setSenha(resultado.getString("Senha"));
                dadoUsuario.setTipo(resultado.getInt("TipoUsuario"));
                dadoUsuario.setTelefone(resultado.getString("Telefone"));
                dadoUsuario.setNome(resultado.getString("Nome"));
                
                professorProcuraro.setEndereco(dadosEndereco);
                professorProcuraro.setUsuario(dadoUsuario);
                
            }else{
                return null;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: - " + e.getMessage());
        }
        
        
        
        return professorProcuraro;
        
    }
    
    
    @Override
    public List<String> listarDisciplinas(Professor professor){
        
        String consulta = "SELECT d.Nome as NomeDisciplina,"
                + " u.Nome as NomeProfessor, p.idProfessor, d.idDisciplina "
                + " FROM aluno_has_disciplina a inner join"
                + " disciplina d on a.idDisciplina = d.idDisciplina"
                + " inner join professor p on d.idProfessor = p.idProfessor"
                + " inner join usuario u on p.idUsuario = u.idUsuario"
                + " WHERE p.idProfessor = ?";
           List<String> materias = new ArrayList<>();
        
            try {
                PreparedStatement stmt;
                stmt = conn.prepareStatement(consulta);
                stmt.setInt(1, professor.getIdProfessor());
                ResultSet resultado = stmt.executeQuery();
                while (resultado.next()) {
             
                    Disciplina disciplina = new Disciplina();
                    disciplina.setNome(resultado.getString("NomeDisciplina"));
                    materias.add(disciplina.getNome());

                }
            } catch (SQLException ex) {
                System.out.println("Erro ao Listar alunos" + ex);
            }
            
    
        return materias;
        
        
    }
    
    
}
