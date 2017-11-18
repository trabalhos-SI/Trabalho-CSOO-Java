/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Endereco;
import modelo.Usuario;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class AlunoDAOJDBC extends DAOBaseJDBC implements AlunoDAO {

    @Override
    public Aluno buscarAluno(Usuario usuario) {

        Aluno alunoProcurado = null;

        String consulta = "SELECT * " + "FROM usuario INNER JOIN aluno ON usuario.idUsuario = aluno.Usuario_idUsuario "
                + "INNER JOIN endereco ON aluno.`Endereco_idEndereco` = endereco.`idEndereco` "
                + "WHERE usuario.idUsuario = ?";

        try {

            PreparedStatement stmt = conn.prepareStatement(consulta);

            stmt.setInt(1, usuario.getIdUser());

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {

                alunoProcurado = new Aluno();
                alunoProcurado.setIdAluno(resultado.getInt("idAluno"));
                //alunoProcurado.setNome(resultado.getString("Nome"));
                //alunoProcurado.setEmail(resultado.getString("Email"));
                //alunoProcurado.setMatricula(resultado.getString("Matricula"));
                //alunoProcurado.setDataNascimento(resultado.getString("DataNascimento"));
                //alunoProcurado.setLogin(resultado.getString("Login"));
                //alunoProcurado.setSenha(resultado.getString("Senha"));
                alunoProcurado.setCurso(resultado.getString("Curso"));
                Endereco dadosEndereco = new Endereco();
                dadosEndereco.setIdEndereco(resultado.getInt("idEndereco"));
                dadosEndereco.setRua(resultado.getString("Rua"));
                dadosEndereco.setBairro(resultado.getString("Bairro"));
                dadosEndereco.setCidade(resultado.getString("Cidade"));
                dadosEndereco.setEstado(resultado.getString("Estado"));
                usuario = new Usuario();
                usuario.setDataNascimento(resultado.getString("DataNascimento"));
                usuario.setLogin(resultado.getString("Login"));
                usuario.setEmail(resultado.getString("Email"));
                usuario.setIdUser(resultado.getInt("idUsuario"));
                usuario.setMatricula(resultado.getString("Matricula"));
                usuario.setSenha(resultado.getString("Senha"));
                usuario.setTipo(resultado.getString("tipo"));
                usuario.setNome(resultado.getString("Nome"));
                alunoProcurado.setEndereco(dadosEndereco);
                alunoProcurado.setUsuario(usuario);

            } else {

                return null;

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro no banco de dados: - " + e.getMessage());

        }

        return alunoProcurado;

    }

}
