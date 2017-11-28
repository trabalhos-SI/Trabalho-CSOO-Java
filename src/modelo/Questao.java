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
public class Questao {
    
    private int idQuestao;
    private int nivel;
    private String assunto;
    private String enunciado;
    private int tipo;
    private Objetiva objetiva;
    private Discursiva discursiva;

    public Questao() {
    }

    public Questao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Objetiva getObjetiva() {
        return objetiva;
    }

    public void setObjetiva(Objetiva objetiva) {
        this.objetiva = objetiva;
    }

    public Discursiva getDiscursiva() {
        return discursiva;
    }

    public void setDiscursiva(Discursiva discursiva) {
        this.discursiva = discursiva;
    }
    
    
    
}
