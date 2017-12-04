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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.AlunoHasDisciplina;
import modelo.Disciplina;
import modelo.Discursiva;
import modelo.Endereco;
import modelo.Objetiva;
import modelo.Professor;
import modelo.Prova;
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
        
//        String consulta = "SELECT d.Nome as NomeDisciplina,"
//                + " u.Nome as NomeProfessor, p.idProfessor, d.idDisciplina "
//                + " FROM aluno_has_disciplina a inner join"
//                + " disciplina d on a.idDisciplina = d.idDisciplina"
//                + " inner join professor p on d.idProfessor = p.idProfessor"
//                + " inner join usuario u on p.idUsuario = u.idUsuario"
//                + " WHERE p.idProfessor = ?";

          String consulta = "SELECT d.Nome as NomeDIsciplina FROM disciplina d INNER JOIN professor p"
                  + " ON d.idProfessor = p.idProfessor WHERE p.idProfessor = ?";
            
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
    
    
    public ObservableList<AlunoHasDisciplina> listarDisciplinaAluno(Aluno aluno, String nome){
        
        ProvaDAOJDBC provajdbc = new ProvaDAOJDBC();
//        String consulta = "SELECT a.MediaFinal, a.MedialParcial, a.idDisciplina, d.Nome as NomeDisciplina,"
//                + " u.Nome as NomeProfessor, p.idProfessor, d.idDisciplina, u.Nome "
//                + " FROM aluno_has_disciplina a inner join"
//                + " disciplina d on a.idDisciplina = d.idDisciplina"
//                + " inner join professor p on d.idProfessor = p.idProfessor"
//                + " inner join usuario u on p.idUsuario = u.idUsuario"
//                + " WHERE d.Nome = ?";

        String consulta = "SELECT u.idUsuario, u.Nome, a.idAluno, ad.MediaParcial, ad.MediaFinal,"
                + " d.idDisciplina, a.idAluno, d.Nome FROM disciplina d INNER JOIN aluno_has_disciplina ad"
                + " ON d.idDisciplina = ad.idDisciplina INNER JOIN aluno a"
                + " ON ad.idAluno = a.idAluno INNER JOIN usuario u"
                + " ON a.idUsuario = u.idUsuario WHERE d.nome = ?";


        ObservableList<AlunoHasDisciplina> materias = FXCollections.observableArrayList();
            
            try {
                PreparedStatement stmt;
                stmt = conn.prepareStatement(consulta);
                stmt.setString(1, nome);
                ResultSet resultado = stmt.executeQuery();
                while (resultado.next()) {
                    AlunoHasDisciplina materia = new AlunoHasDisciplina();
                    materia.setAluno(aluno);
                    materia.setMediaFinal(resultado.getDouble("MediaFinal"));
                    materia.setMediaParcial(resultado.getDouble("MediaParcial"));
                   
                    
                    Disciplina disciplina = new Disciplina();
                    disciplina.setIdDisciplina(resultado.getInt("idDisciplina"));
                    disciplina.setNome(resultado.getString("d.Nome"));
                    
                    
                    Usuario usuario = new Usuario();
                    usuario.setNome(resultado.getString("u.Nome"));
                    usuario.setIdUser(resultado.getInt("u.idUsuario"));
                    
                    Aluno alunos = new Aluno();
                    alunos.setIdAluno(resultado.getInt("a.idAluno"));
                    
                    alunos.setUsuario(usuario);
                    
                    Professor professor = new Professor();
                   // professor.setIdUser(resultado.getInt("idProfessor"));
                    professor.setUsuario(usuario);
                    
                    disciplina.setProfessor(professor);
                    
                    materia.setDisciplina(disciplina);
                    
                    Prova prova1 = provajdbc.pegarProva(1,disciplina.getIdDisciplina());
                    materia.setProva1(prova1);
                    Prova prova2 = provajdbc.pegarProva(2,disciplina.getIdDisciplina());
                    materia.setProva2(prova2);
                    Prova provaFinal = provajdbc.pegarProva(3, disciplina.getIdDisciplina());
                    materia.setProvaFinal(provaFinal);
                    materia.setAluno(alunos);
                    materias.add(materia);
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao Listar alunos" + ex);
            }

        
        
        return materias;
        
    }
    
    public ObservableList<Objetiva> listarQuestoesObjetivas(){
        
        
        String consulta = "SELECT o.alternativaA, o.alternativaB, o.alternativaC, o.alternativaD, "
                + "o.alternativaE, o.alternativaCorreta, o.idQuestao, q.idQuestao, q.Nivel, q.Assunto, q.Enunciado, "
                + "q.Tipo FROM Objetiva o INNER JOIN Questao q "
                + "ON q.idQuestao = o.idQuestao";

        ObservableList<Objetiva> questoesObj = FXCollections.observableArrayList();
        
        try{
            PreparedStatement stmt;
            stmt = conn.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();
            
                while(resultado.next()){
                    
                Objetiva objetivas = new Objetiva();
                objetivas.setAlternativaA(resultado.getString("alternativaA"));
                objetivas.setAlternativaB(resultado.getString("alternativaB"));
                objetivas.setAlternativaC(resultado.getString("alternativaC"));
                objetivas.setAlternativaD(resultado.getString("alternativaD"));
                objetivas.setAlternativaE(resultado.getString("alternativaE"));
                objetivas.setAlternativaCorreta(resultado.getInt("alternativaCorreta"));
                objetivas.setIdQuestao(resultado.getInt("idQuestao"));
                objetivas.setNivel(resultado.getInt("Nivel"));
                objetivas.setAssunto(resultado.getString("Assunto"));
                objetivas.setEnunciado(resultado.getString("Enunciado"));
                objetivas.setTipo(resultado.getInt("Tipo"));
                questoesObj.add(objetivas);
                    
                }
                
                    
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro carregar objetiva" + ex.getMessage());
        }
        
        return questoesObj;
    }
    
    public ObservableList<Discursiva> listarQuestoesDiscursivas(){
        
        String consulta = "SELECT d.respostaEsperada, d.idQuestao, q.idQuestao, q.Nivel, "
                + "q.Assunto, q.Enunciado, q.Tipo FROM Questao q INNER JOIN Discursiva d "
                + "ON q.idQuestao = d.idQuestao";
        
        ObservableList<Discursiva> questoesDisc = FXCollections.observableArrayList();
        
        try{
            PreparedStatement stmt;
            stmt = conn.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                
                Discursiva discursivas = new Discursiva();
                
                discursivas.setIdQuestao(resultado.getInt("idQuestao"));
                discursivas.setNivel(resultado.getInt("Nivel"));
                discursivas.setAssunto(resultado.getString("Assunto"));
                discursivas.setEnunciado(resultado.getString("Enunciado"));
                discursivas.setTipo(resultado.getInt("Tipo"));
                discursivas.setRespostaEsperada(resultado.getString("respostaEsperada"));
                questoesDisc.add(discursivas);
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro carregar discursiva" + ex.getMessage());
        }
        
        return questoesDisc;
        
        
    }
    
    
}
