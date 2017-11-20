/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Aluno;
import modelo.Professor;
import modelo.Usuario;

/**
 *
 * @author Leandro
 */
public interface ProfessorDAO {
    
    public Professor buscarProfessor(Usuario usuario);
}
