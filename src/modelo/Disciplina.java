/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Leandro
 */
public class Disciplina {
    
    private int idDisciplina;
    private String nome;
    private Professor professor;
    private AlunoHasDisciplina alunoXdisciplina;

    public Disciplina(AlunoHasDisciplina alunoXdisciplina) {
        this.alunoXdisciplina = alunoXdisciplina;
    }

    public AlunoHasDisciplina getAlunoXdisciplina() {
        return alunoXdisciplina;
    }

    public void setAlunoXdisciplina(AlunoHasDisciplina alunoXdisciplina) {
        this.alunoXdisciplina = alunoXdisciplina;
    }
    
    

    public Disciplina() {
    }

    public Disciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Disciplina(Professor professor) {
        this.professor = professor;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
    
}
