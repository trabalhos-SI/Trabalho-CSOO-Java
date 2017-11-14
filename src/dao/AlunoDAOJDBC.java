/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Usuario;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class AlunoDAOJDBC extends DAOBaseJDBC implements AlunoDAO {
    
    public static int idGeral;
    
    @Override
    public Aluno buscarAluno(Usuario usuario){
        
        Aluno alunoLido = null;
        String consulta = "SELECT U.Nome, U.Email, U.Matricula, U.DataNascimento, " // SEM REFERENCIA NO BANCO DE DADOS
        
        
        return alunoLido;
    }
    
    
       
}
