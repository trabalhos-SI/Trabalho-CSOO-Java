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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.AlunoHasDisciplina;
import modelo.Disciplina;
import modelo.Endereco;
import modelo.Professor;
import modelo.Prova;
import modelo.Usuario;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class AlunoDAOJDBC extends DAOBaseJDBC implements AlunoDAO {

  
    @Override
    public Aluno buscarAluno(Usuario usuario) {


        Aluno alunoProcurado = null;
        String consulta = "SELECT *"
                + " FROM usuario INNER JOIN aluno"
                + " ON usuario.idUsuario = aluno.idUsuario"
                + " INNER JOIN endereco ON endereco.idEndereco = Aluno.idEndereco"
                + " INNER JOIN aluno_has_disciplina ON aluno.idAluno = aluno_has_disciplina.idAluno"
                + " INNER JOIN disciplina ON disciplina.idDisciplina = aluno_has_disciplina.idDisciplina"
                + " INNER JOIN professor ON professor.idProfessor = disciplina.idProfessor"
                + " WHERE aluno.idUsuario = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, usuario.getIdUser());
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                alunoProcurado = new Aluno();
                alunoProcurado.setIdAluno(resultado.getInt("idAluno"));
                alunoProcurado.setCurso(resultado.getString("Curso"));
                alunoProcurado.setTurma(resultado.getString("Turma"));

                Endereco dadosEndereco = new Endereco();

                dadosEndereco.setIdEndereco(resultado.getInt("idEndereco"));
                dadosEndereco.setRua(resultado.getString("Rua"));
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
                
     
                Set<Disciplina> listDisciplinas = null;
                listDisciplinas = new HashSet<Disciplina>();
                
    
                while(resultado.next()){
                    
                    Disciplina disc = new Disciplina();
                    disc.setIdDisciplina(resultado.getInt("idDisciplina"));
                    disc.setNome(resultado.getString("Nome"));
                    listDisciplinas.add(disc);
                }
                

                alunoProcurado.setEndereco(dadosEndereco);
                alunoProcurado.setUsuario(dadoUsuario);

            } else {
                return null;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: - " + e.getMessage());

        }

        return alunoProcurado;
    }
    
     @Override
     public List<Aluno> listarAlunos() {

        Aluno alunoProcurado = null;
        String consulta = "SELECT * FROM usuario";
        List<Aluno> alunos = new ArrayList();
        {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(consulta); 

                ResultSet resultado = stmt.executeQuery();
                while (resultado.next()) {
                    alunoProcurado = new Aluno();
                    alunoProcurado.setIdAluno(resultado.getInt("idUsuario"));
                    alunoProcurado.setMatricula(resultado.getString("Matricula"));

                    alunos.add(alunoProcurado);

                }
            } catch (SQLException ex) {
                System.out.println("Erro ao Listar alunos" + ex);
            }

        }
        
        return alunos;
    }
     
    @Override
    public ObservableList<AlunoHasDisciplina> listarDisciplina(Aluno aluno) {
        ProvaDAOJDBC provajdbc = new ProvaDAOJDBC();
        String consulta = "SELECT a.MediaFinal, a.MediaParcial, a.idDisciplina, d.Nome as NomeDisciplina,"
                + " u.Nome as NomeProfessor, p.idProfessor, d.idDisciplina "
                + " FROM aluno_has_disciplina a inner join"
                + " disciplina d on a.idDisciplina = d.idDisciplina"
                + " inner join professor p on d.idProfessor = p.idProfessor"
                + " inner join usuario u on p.idUsuario = u.idUsuario"
                + " WHERE idAluno = ?";
        ObservableList<AlunoHasDisciplina> materias = FXCollections.observableArrayList();
            
            try {
                PreparedStatement stmt;
                stmt = conn.prepareStatement(consulta);
                stmt.setInt(1, aluno.getIdAluno());
                ResultSet resultado = stmt.executeQuery();
                while (resultado.next()) {
                    
                    AlunoHasDisciplina materia = new AlunoHasDisciplina();
                    materia.setAluno(aluno);
                    materia.setMediaFinal(resultado.getDouble("MediaFinal"));
                    materia.setMediaParcial(resultado.getDouble("MediaParcial"));
                    
                  
                    
                    
                    Disciplina disciplina = new Disciplina();
                    disciplina.setIdDisciplina(resultado.getInt("idDisciplina"));
                    disciplina.setNome(resultado.getString("NomeDisciplina"));
                    
                    Usuario usuario = new Usuario();
                    usuario.setNome(resultado.getString("NomeProfessor"));
                    
                    Professor professor = new Professor();
                    professor.setIdUser(resultado.getInt("idProfessor"));
                    professor.setUsuario(usuario);
                    
                    disciplina.setProfessor(professor);
                    
                    materia.setDisciplina(disciplina);
                    
                    Prova prova1 = provajdbc.pegarProva(1,disciplina.getIdDisciplina());
                    materia.setProva1(prova1);
                    Prova prova2 = provajdbc.pegarProva(2,disciplina.getIdDisciplina());
                    materia.setProva2(prova2);
                    Prova provaFinal = provajdbc.pegarProva(3, disciplina.getIdDisciplina());
                    materia.setProvaFinal(provaFinal);
                    
                    materias.add(materia);
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao Listar alunos" + ex);
            }

        
        
        return materias;
    }
    
    public void salvarAluno(Aluno aluno){
        
        String consulta = "UPDATE Usuario SET Telefone = ?,DataNascimento = ?, Email = ? "
                + "WHERE idUsuario = ?";
        
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, aluno.getTelefone());
            stmt.setString(2, aluno.getDataNascimento());
            stmt.setString(3, aluno.getEmail());
            stmt.setInt(4, aluno.getIdAluno());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

}
