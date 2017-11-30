/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Discursiva;
import modelo.Objetiva;
import visao.TelaQuestaoObjController;

/**
 *
 * @author Leandro
 */
public interface QuestaoDAO {
    
    public void cadastrarQuestaoObjetiva(Objetiva objetiva);
    public void cadastrarQuestaoDiscursiva(Discursiva discursiva);
    public int ultimoIdCadastrado();
    public void incluirObjetiva(Objetiva objetiva);
    public void incluirDiscursiva(Discursiva discursiva);
}
