/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Aluno;

/**
 *
 * @author Leandro
 */
public interface AlunoDAO {
    
    /**
     * 
     * @param user usuario do aluno.
     * @param password senha do aluno.
     * @return - Retornara um aluno pelo seu usuario e senha.
     */
    public Aluno consultarLogin(String user, String password);
    
}
