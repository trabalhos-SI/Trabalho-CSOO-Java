/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class AlunoDAOJDBC extends DAOBaseJDBC implements AlunoDAO {
    
    @Override
    public Aluno consultarLogin(String user, String password){
        
        Aluno alunoLido = null;
        
        try{
            JOptionPane.showMessageDialog(null, "######");
            
        }catch(HeadlessException e){
            
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e.getMessage());
        }
        
        return alunoLido;
    }
    
}
