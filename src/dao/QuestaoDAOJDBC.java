/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import modelo.Objetiva;
import modelo.Questao;
import tools.DAOBaseJDBC;
import visao.TelaQuestaoObjController;

/**
 *
 * @author Leandro
 */
public class QuestaoDAOJDBC extends DAOBaseJDBC implements QuestaoDAO{
    
    @Override
    public void cadastrarQuestaoObjetiva(Objetiva objetiva){
        
        TelaQuestaoObjController telaObj = new TelaQuestaoObjController();
        String consulta = "INSERT INTO Questao(Nivel, Assunto, Enunciado, Tipo) VALUES"
                + "(?, ?, ?, ?)";
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, objetiva.getNivel());
            stmt.setString(2, objetiva.getAssunto());
            stmt.setString(3, objetiva.getEnunciado());
            stmt.setInt(4, objetiva.getTipo());
            stmt.executeUpdate();
            stmt.close();
      
        } catch (SQLException ex) {
            Logger.getLogger(QuestaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
              
       
           
    }
    
    public void incluirObjetiva(Objetiva objetiva){
        
        String consulta = "INSERT INTO Objetiva(alternativaA, alternativaB, alternativaC, alternativaD"
                + ", alternativaE, alternativaCorreta, idQuestao) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
         try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, objetiva.getAlternativaA());
            stmt.setString(2, objetiva.getAlternativaB());
            stmt.setString(3, objetiva.getAlternativaC());
            stmt.setString(4, objetiva.getAlternativaD());
            stmt.setString(5, objetiva.getAlternativaE());
            stmt.setInt(6, objetiva.getAlternativaCorreta());
            stmt.setInt(7, objetiva.getIdQuestao());
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro sql1111");
        }
        
    }
    
    
    
    @Override
    public int ultimoIdCadastrado(){
        
        int ultimoCadastroId = 0;
        String consulta = "SELECT idQuestao FROM questao ORDER BY idQuestao DESC LIMIT 1";
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consulta);
            
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                
                ultimoCadastroId = resultado.getInt("idQuestao");
            }
            
            System.out.println("teste id: " + ultimoCadastroId);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro sql");
        }
        
        return ultimoCadastroId;
        
    }
    

}


