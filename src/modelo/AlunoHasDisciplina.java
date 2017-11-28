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
    private Prova Prova1;
    private Prova Prova2;
    private Prova ProvaFinal;
    
    
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

    public String getDisciplinaNome(){
        return this.Disciplina.getNome();
    }
    public String getAlunoNome(){
        return this.Aluno.usuario.getNome();
    }

    public Prova getProva1() {
        return Prova1;
    }

    public void setProva1(Prova Prova1) {
        this.Prova1 = Prova1;
    }

    public Prova getProva2() {
        return Prova2;
    }

    public void setProva2(Prova Prova2) {
        this.Prova2 = Prova2;
    }
    
    public Double getNotaProva1(){
        return this.Prova1.getNota();
    }
    
    public Double getNotaProva2(){
        return this.Prova2.getNota();
    }
    
    public Double getNotaProvaFinal(){
        return this.ProvaFinal.getNota();
    }

    public Prova getProvaFinal() {
        return ProvaFinal;
    }

    public void setProvaFinal(Prova ProvaFinal) {
        this.ProvaFinal = ProvaFinal;
    }
    
   
    
    
}
