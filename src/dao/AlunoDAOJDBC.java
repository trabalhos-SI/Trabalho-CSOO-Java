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
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.AlunoHasDisciplina;
import modelo.Disciplina;
import modelo.Endereco;
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
    
     public static List<Aluno> listarAlunos() {

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
     
     
//     public static List<AlunoHasDisciplina> listarDisciplina(Aluno aluno) {
//
//        Disciplina disc;
//        String consulta = "SELECT * FROM aluno_has_disciplina WHERE idALuno = ?";
//        List<Disciplina> disciplinas = new ArrayList();
//        {
//            PreparedStatement stmt;
//            try {
//             stmt = conn.prepareStatement(consulta);
//             stmt.setInt(1, aluno.getIdAluno());
//             ResultSet resultado = stmt.executeQuery();
//                while (resultado.next()) {
//                    disc = new Disciplina();
//                    disc.setIdDisciplina(resultado.("idDisciplina"));
//                    disc.set(resultado.getString("Matricula"));
//
//                    disciplinas.add(disc);
//
//                }
//            } catch (SQLException ex) {
//                System.out.println("Erro ao Listar alunos" + ex);
//            }
//
//        }
//        
//        return alunos;
//    }

}
