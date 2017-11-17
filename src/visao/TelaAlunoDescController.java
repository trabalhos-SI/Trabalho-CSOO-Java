/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.AlunoDAOJDBC;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Aluno;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaAlunoDescController extends AlunoDAOJDBC implements Initializable {

    @FXML
    private AnchorPane Tela_Dados;
    @FXML
    private Label lb_tel;
    @FXML
    private Label lbTeste1;
    @FXML
    private Label lb_nome;
    @FXML
    private Label lb_curso;
    @FXML
    private Label lb_turma;
    @FXML
    private Label lb_matricula;
    @FXML
    private Label lb_data;
    @FXML
    private Label lb_email;
    @FXML
    private AnchorPane Tela_Disci;
    @FXML
    private Label lb_titulo;
    @FXML
    private Label lbTeste11;
    @FXML
    private TableView<?> tb_disciplina;
    @FXML
    private Label lb;
    @FXML
    private Button btn_dados;
    @FXML
    private Button btn_disciplina;

       
    /**
     * Initializes the controller class.
     * @param stage
     */
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        aluno = buscarAluno(TelaLoginController.usuario);
        
         
             
       }

    @FXML
    private void initialize(MouseEvent event) {
        
        lb_nome.setText(aluno.getNome());
        lb_curso.setText(aluno.getCurso());
        //lb_turma.setText(aluno.s);
        lb_matricula.setText(aluno.getMatricula());
        lb_data.setText(aluno.getDataNascimento());
        lb_email.setText(aluno.getEmail());
        
        
    }

    @FXML
    private void initialize(ActionEvent event) {
    }
    
    
    
}
