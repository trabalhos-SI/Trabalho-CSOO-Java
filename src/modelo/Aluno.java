/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Set;

/**
 *
 * @author Leandro
 */
public class Aluno extends Usuario {
    
    private int idAluno;
    private String Curso;
    private Set<Endereco> endereco;

    public Aluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public Aluno() {
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public Set<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }
    
    
    
    
    
    
}
