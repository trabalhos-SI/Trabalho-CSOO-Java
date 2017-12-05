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
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public interface AlunoDAO {
    
    /**
     * 
     * @param usuario
     * @param user usuario do aluno.
     * @param password senha do aluno.
     * @return - Retornara um aluno pelo seu usuario e senha.
     */
    public Aluno buscarAluno(Usuario usuario);
    public ObservableList<AlunoHasDisciplina> listarDisciplina(Aluno aluno);
    public List<Aluno> listarAlunos();
    public void salvarAluno(Aluno aluno);
}
