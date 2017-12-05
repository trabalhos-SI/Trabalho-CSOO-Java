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
import modelo.Disciplina;
import modelo.Prova;
import tools.DAOBaseJDBC;

/**
 *
 * @author Pedro Henrique
 */
public class ProvaDAOJDBC extends DAOBaseJDBC implements ProvaDAO{

    @Override
    public Prova pegarProva(int tipo, int idDisciplina) {
        String consulta = "SELECT *"
                + " FROM prova p inner join disciplina d on p.idDisciplina = d.idDisciplina"
                + " WHERE Tipo = ? and p.idDisciplina = ?";
        Prova prova = null;
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, tipo);
            stmt.setInt(2, idDisciplina);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                prova = new Prova();
                prova.setIdProva(result.getInt("idProva"));
                prova.setBimestre(result.getInt("Bimestre"));                
                prova.setAno(result.getInt("Ano"));
                prova.setSemestre(result.getInt("Semestre"));
                prova.setNota(result.getDouble("Nota"));
                prova.setTipo(result.getInt("Tipo"));
                
                Disciplina disciplina = new Disciplina();
                disciplina.setNome(result.getString("Nome"));
                
                prova.setDisciplina(disciplina);
            }
            else{
                prova = new Prova();
                //prova.setNota(0.0);
            }
        } catch (SQLException ex) {
             System.out.println("Error :" + ex);
        }
        return prova;
    }
    
    @Override
    public ObservableList<String> listarIdProvas(){
       
        ObservableList<String> listarIds = FXCollections.observableArrayList();
        
        String consulta = "SELECT * FROM Prova";
        
        List<String> lista = new ArrayList<>();
        
        try{
            PreparedStatement stmt;
            stmt = conn.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                
               // lista.add(Integer.toString(resultado.getInt("idProva")));
                listarIds.add(Integer.toString(resultado.getInt("idProva")));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProvaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listarIds;
        
        
    }
    
    public void MontarQuestaoProva(int idQuestao, int idProva){
        
        String consulta = "INSERT INTO QuestaoProva(Questao_idQuestao, Prova_idProva) VALUES"
                + "(?, ?)";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, idQuestao);
            stmt.setInt(2, idProva);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi possivel vincular questão a prova");
        }
    }
    
    public void registrarProva(Prova prova, int idDisciplina){
        
        String consulta = "INSERT INTO Prova(Bimestre, Ano, Semestre, idDisciplina, Nota, Tipo) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, prova.getBimestre());
            stmt.setInt(2, prova.getAno());
            stmt.setInt(3, prova.getSemestre());
            stmt.setInt(4, idDisciplina);
            stmt.setDouble(5, prova.getNota());
            stmt.setInt(6, prova.getTipo());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProvaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public boolean buscarProva(Prova prova){
        
        String consulta = "SELECT * FROM Prova WHERE idProva = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, prova.getIdProva());
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                return true;
            }
   
        } catch (SQLException ex) {
            Logger.getLogger(ProvaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
  
    }
    
    public void deletarProva(Prova prova){
        
        String consulta = "DELETE FROM QuestaoProva WHERE Prova_idProva = ?";
        String consulta2 = "DELETE FROM Prova WHERE idProva = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, prova.getIdProva());
            stmt.executeUpdate();
            stmt.close();
            stmt = conn.prepareStatement(consulta2);
            stmt.setInt(1, prova.getIdProva());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProvaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
   
    
}
