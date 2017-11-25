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
public class AlunoHasDisciplina {
    
    private Disciplina Disciplina;
    private Aluno Aluno;
    private Double mediaParcial;
    private Double mediaFinal;

    public AlunoHasDisciplina() {
    }

    public AlunoHasDisciplina(Aluno Aluno) {
        this.Aluno = Aluno;
    }
    

    public Disciplina getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(Disciplina Disciplina) {
        this.Disciplina = Disciplina;
    }

    public Aluno getAluno() {
        return Aluno;
    }

    public void setAluno(Aluno Aluno) {
        this.Aluno = Aluno;
    }

    

    public Double getMediaParcial() {
        return mediaParcial;
    }

    public void setMediaParcial(Double mediaParcial) {
        this.mediaParcial = mediaParcial;
    }

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    
    
}
