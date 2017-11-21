/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.AlunoDAO;
import dao.AlunoDAOJDBC;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import modelo.Aluno;
import modelo.Disciplina;
import static visao.TelaLoginController.usuario;


/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaAlunoDescController implements Initializable {
    
    @FXML
    private AnchorPane Tela_Disci;
    @FXML
    private Label lb_titulo;
    @FXML
    private AnchorPane Tela_Dados;
    @FXML
    private Label lb_tel;
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
    private Button btn_dados;
    @FXML
    private Button btn_disciplina;
    
    private AlunoDAOJDBC alunojdbc;
    @FXML
    private Label lbTeste1;
    @FXML
    private Label lbTeste11;
    @FXML
    private TableColumn<?, ?> cl_disciplinaAluno;
    @FXML
    private TableColumn<?, ?> cl_prova1Aluno;
    @FXML
    private TableColumn<?, ?> cl_prova2Aluno;
    @FXML
    private TableColumn<?, ?> cl_mpAluno;
    @FXML
    private TableColumn<?, ?> cl_pfAluno;
    @FXML
    private TableColumn<?, ?> cl_mediaFinalAluno;
    @FXML
    private Label lb;
  
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
       
    
    @Override
    @SuppressWarnings("empty-statement")
    public void initialize(URL url, ResourceBundle rb) {
        
        Aluno aluno;
        AlunoDAOJDBC alunojdbc;
        alunojdbc = new AlunoDAOJDBC();       
        aluno = alunojdbc.buscarAluno(usuario);

        lb_curso.setText(aluno.getCurso());
        lb_nome.setText(aluno.usuario.getNome());
        lb_turma.setText(aluno.getTurma());
        lb_matricula.setText(aluno.usuario.getMatricula());
        lb_data.setText(aluno.usuario.getDataNascimento());
        lb_email.setText(aluno.usuario.getEmail());
        lb_tel.setText(aluno.usuario.getTelefone());
        
        
       
     
        
        btn_dados.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                Tela_Dados.toFront();
            }
      
            
        });
        
        btn_disciplina.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                Tela_Disci.toFront();
                
                
               
            }
            
            
            
        });
             
       }//FIM DO INITIALIZE
    
}
