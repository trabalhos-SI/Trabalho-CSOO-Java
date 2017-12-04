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
import modelo.Professor;
import modelo.Usuario;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class CoordenadorDAOJDBC extends DAOBaseJDBC implements CoordenadorDAO{
    
    public Aluno buscarMatriculaAluno(String matricula){
        
        Aluno alunoprocurado = null;
        String consulta = "SELECT a.idAluno, a.idUsuario, u.idUsuario, u.Nome, u.Matricula FROM "
                + "Usuario u INNER JOIN Aluno a ON u.idUsuario = a.idUsuario WHERE u.Matricula = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, matricula);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()){
                alunoprocurado = new Aluno();
                alunoprocurado.setIdAluno(resultado.getInt("idAluno"));
                alunoprocurado.setIdUser(resultado.getInt("idUsuario"));
                
                Usuario user = new Usuario();
                user.setIdUser(resultado.getInt("idUsuario"));
                user.setNome(resultado.getString("Nome"));
                user.setMatricula(resultado.getString("Matricula"));
                
                alunoprocurado.setUsuario(user);
                
                
                
            }else{
                
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CoordenadorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return alunoprocurado;
        
    }
    
    public ObservableList<Aluno> popularTabela(String matricula){
        
        String consulta = "SELECT a.idAluno, a.idUsuario, u.idUsuario, u.Matricula, u.Nome FROM Usuario u INNER JOIN "
                + "Aluno a ON a.idUsuario = u.idUsuario WHERE u.Matricula = ?";
        
        ObservableList<Aluno> dadosAluno = FXCollections.observableArrayList();
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, matricula);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                
                Aluno aluno = new Aluno();
                aluno.setIdAluno(resultado.getInt("idAluno"));
                aluno.setMatricula(resultado.getString("Matricula"));
                aluno.setNome(resultado.getString("Nome"));
                
                dadosAluno.add(aluno);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CoordenadorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return dadosAluno;
    }
    
    public ObservableList<Disciplina> popularTabelaDisciplinas(int id){
        
        ObservableList<Disciplina> dadosDisciplinas = FXCollections.observableArrayList();
        
        String consulta = "SELECT d.idDisciplina, d.Nome, d.idProfessor, p.idProfessor, p.idUsuario, "
                + "u.idUsuario, u.Nome, u.Matricula, a.idAluno, a.idUsuario, al.idDisciplina, al.idAluno "
                + "FROM Aluno_has_Disciplina al INNER JOIN Aluno a ON al.idAluno = a.idAluno INNER JOIN "
                + "Usuario u ON a.idUsuario = u.idUsuario INNER JOIN Professor p ON u.idUsuario = p.idUsuario "
                + "INNER JOIN Disciplina d ON p.idProfessor = d.idProfessor WHERE u.Matricula = ?";
        
        String consulta2 = "SELECT d.idDisciplina, d.Nome, d.idProfessor, p.idProfessor, p.idUsuario, "
                + "u.idUsuario, u.Nome, al.idDisciplina, al.idAluno, a.idAluno FROM Aluno a INNER JOIN "
                + "Aluno_has_Disciplina al ON al.idAluno = a.idAluno INNER JOIN Disciplina d ON "
                + "d.idDisciplina = al.idDisciplina INNER JOIN Professor p ON p.idProfessor = d.idProfessor "
                + "INNER JOIN Usuario u ON u.idUsuario = p.idUsuario WHERE a.idAluno = ?";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consulta2);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                Disciplina dis = new Disciplina();
                dis.setIdDisciplina(resultado.getInt("idDisciplina"));
                dis.setNome(resultado.getString("d.Nome"));
                Professor prof = new Professor();
                prof.setIdUser(resultado.getInt("p.idUsuario"));
                prof.setNome(resultado.getString("u.Nome"));
                dis.setProfessor(prof);
                dadosDisciplinas.add(dis);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CoordenadorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
         return dadosDisciplinas;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<String> retornarDisciplinas(){
        

        String consulta = "SELECT * FROM Disciplina";
        List<String> retorno = new ArrayList<>();
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                Disciplina disc = new Disciplina();
                disc.setIdDisciplina(resultado.getInt("idDisciplina"));
                disc.setNome(resultado.getString("Nome"));
                retorno.add(disc.getNome());
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordenadorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
        return retorno;
        
    }
    
    public void matricularAluno(int idD, int idA){
        
        String consulta = "INSERT INTO Aluno_has_Disciplina(idDisciplina, idAluno) VALUES"
                + "(?, ?)";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, idD);
            stmt.setInt(2, idA);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CoordenadorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int retornarIdDisciplina(String nome){
        
        int num = 0;
        
        String consulta = "SELECT * FROM Disciplina WHERE Nome = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, nome);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()){
                
                num = resultado.getInt("idDisciplina");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordenadorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return num;
        
    }
    
    public int retornarIdAluno(String matricula){
        
        int num = 0;
        String consulta = "SELECT * FROM Aluno a INNER JOIN Usuario u ON a.idUsuario = u.idUsuario "
                + "WHERE u.Matricula = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, matricula);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()){
                
                num = resultado.getInt("idAluno");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CoordenadorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return num;
        
    }
        
    
}
