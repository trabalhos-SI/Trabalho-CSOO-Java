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
    
}
