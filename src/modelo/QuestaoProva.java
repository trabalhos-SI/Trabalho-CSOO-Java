/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Leandro
 */
public class QuestaoProva {
    
    private int questao_idQuestao;
    private int prova_idProva;
    private Date dataProva;

    public QuestaoProva() {
    }

    public QuestaoProva(int questao_idQuestao, int prova_idProva) {
        this.questao_idQuestao = questao_idQuestao;
        this.prova_idProva = prova_idProva;
    }

    public int getQuestao_idQuestao() {
        return questao_idQuestao;
    }

    public void setQuestao_idQuestao(int questao_idQuestao) {
        this.questao_idQuestao = questao_idQuestao;
    }

    public int getProva_idProva() {
        return prova_idProva;
    }

    public void setProva_idProva(int prova_idProva) {
        this.prova_idProva = prova_idProva;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }
    
    
    
    
}
