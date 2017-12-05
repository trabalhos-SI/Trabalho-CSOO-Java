/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import javafx.collections.ObservableList;
import modelo.Prova;

/**
 *
 * @author Pedro Henrique
 */
public interface ProvaDAO {
    
    public Prova pegarProva(int tipo, int idDisciplina);
    public ObservableList<String> listarIdProvas();
    public void MontarQuestaoProva(int idquestao, int idProva);
    public void registrarProva(Prova prova, int idDisciplina);

}
