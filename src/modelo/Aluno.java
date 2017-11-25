/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Leandro
 */
public class Aluno extends Usuario {
    
    private int idAluno;
    private String Curso;
    private String turma;
    private Endereco endereco;
    public Usuario usuario;
    private List<AlunoHasDisciplina> Materias;

    public Aluno(){
        this.Materias = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Aluno{" + "idAluno=" + idAluno + ", Curso=" + Curso + ", turma=" + turma + ", endereco=" + endereco + ", usuario=" + usuario.toString() + '}';
    }
    
    
    
    public List<AlunoHasDisciplina> getMaterias() {
        return Materias;
    }

    public void setMaterias(List<AlunoHasDisciplina> Materias) {
        this.Materias = Materias;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Aluno(int idAluno) {
        this.idAluno = idAluno;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }    
    
}
