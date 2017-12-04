/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javafx.collections.ObservableList;
import modelo.Aluno;
import modelo.AlunoHasDisciplina;
import modelo.Disciplina;

/**
 *
 * @author Leandro
 */
public interface CoordenadorDAO {
    
    public Aluno buscarMatriculaAluno(String matricula);
    public ObservableList<Aluno> popularTabela(String Matricula);
    public ObservableList<Disciplina> popularTabelaDisciplinas(int id);
    public List<String> retornarDisciplinas();
    public void matricularAluno(int idA, int idD);
    public int retornarIdDisciplina(String nome);
    public int retornarIdAluno(String matricula);
}
