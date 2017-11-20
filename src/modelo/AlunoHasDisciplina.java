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
    
    private int idDidciplina;
    private int idAluno;
    private Double mediaParcial;
    private Double mediaFinal;

    public AlunoHasDisciplina() {
    }

    public AlunoHasDisciplina(int idDidciplina, int idAluno) {
        this.idDidciplina = idDidciplina;
        this.idAluno = idAluno;
    }

    public int getIdDidciplina() {
        return idDidciplina;
    }

    public void setIdDidciplina(int idDidciplina) {
        this.idDidciplina = idDidciplina;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
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
