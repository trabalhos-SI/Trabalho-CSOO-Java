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
import modelo.Discursiva;
import modelo.Objetiva;
import modelo.Professor;
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public interface ProfessorDAO {
    
    public Professor buscarProfessor(Usuario usuario);
    public List<String> listarDisciplinas(Professor professor);
    public ObservableList<AlunoHasDisciplina> listarDisciplinaAluno(Aluno aluno, String nome);
    public ObservableList<Objetiva> listarQuestoesObjetivas();
    public ObservableList<Discursiva> listarQuestoesDiscursivas();
}
