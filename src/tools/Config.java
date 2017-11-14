/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 * Classe interface responsável por guardar informações para conexão ao banco
 * de dados.
 * @author Leandro
 */
public interface Config {
    
    public static final String NOME_DRIVER = "com.mysql.jdbc.Driver";
    public static final String BD_URL = "jdbc:mysql://localhost:3306/mydb"; // #DEFINIR A BASE DE DADOS E MODIFICAR
    public static final String BD_LOGIN = "root";
    public static final String BD_SENHA = "";
}
