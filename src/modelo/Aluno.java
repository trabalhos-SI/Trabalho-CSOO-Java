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
    private Endereco endereco;
    public Usuario usuario;

    
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Aluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public Aluno() {
        this.endereco = new Endereco();
        this.usuario = new Usuario();
        
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
