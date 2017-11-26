/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.AlunoDAOJDBC;
import dao.ProfessorDAOJDBC;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javax.swing.Action;
import modelo.Aluno;
import modelo.Disciplina;
import modelo.Professor;
import modelo.Usuario;
import static visao.TelaLoginController.usuario;


/**
 * FXML Controller class
 *
 * @author lipe0
 */
public class TelaProfessorController implements Initializable {

    @FXML
    private AnchorPane Tela_DisciplinaProf;
    @FXML
    private Label lb_tel1;
    @FXML
    private Label lbTeste11;
    @FXML
    private ChoiceBox<String> cb_turma;
    @FXML
    private TableColumn<?, ?> cl_disciplinaProf;
    @FXML
    private TableColumn<?, ?> cl_prova1Prof;
    @FXML
    private TableColumn<?, ?> cl_prova2Prof;
    @FXML
    private TableColumn<?, ?> cl_mpProf;
    @FXML
    private TableColumn<?, ?> cl_pfProf;
    @FXML
    private TableColumn<?, ?> cl_mediaFinalProf;
    @FXML
    private Label lb;
    @FXML
    private AnchorPane Tela_QuestoesProf;
    @FXML
    private Label lb_tel11;
    @FXML
    private Label lbTeste111;
    @FXML
    private AnchorPane Tela_DadosProf;
    @FXML
    private Label lb_tel;
    @FXML
    private Label lbTeste1;
    @FXML
    private Label lb_nomeProf;
    @FXML
    private Label lb_formacaoProf;
    @FXML
    private Label lb_tituloProf;
    @FXML
    private Label lb_matriculaProf;
    @FXML
    private Label lb_dataProf;
    @FXML
    private Label lb_emailProf;
    @FXML
    private Label lb_telefoneProf;
    @FXML
    private Button btn_dadosProf;
    @FXML
    private Button btn_disciplinaProf;
    @FXML
    private Button btn_QuestaoProf;
    @FXML
    private Button btn_listar;

    private final List<Disciplina> listDisciplina = new ArrayList<>();
    @FXML
    private ComboBox<String> cb_teste;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Professor professor;
        ProfessorDAOJDBC professorjdbc;
        professorjdbc = new ProfessorDAOJDBC();
        professor = professorjdbc.buscarProfessor(usuario);
        
        lb_nomeProf.setText(professor.usuario.getNome());
        lb_formacaoProf.setText(professor.getFormacao());
        lb_tituloProf.setText(professor.getTitulo());
        lb_matriculaProf.setText(professor.usuario.getMatricula());
        lb_dataProf.setText(professor.usuario.getDataNascimento());
        lb_emailProf.setText(professor.usuario.getEmail());
        lb_telefoneProf.setText(professor.usuario.getTelefone());
        
        
        // USANDO O CHOICEBOX
        
        cb_teste.setTooltip(new Tooltip("Selecione a disciplina"));
        cb_teste.setValue( "" );
        cb_teste.setItems(FXCollections.observableArrayList(professorjdbc.listarDisciplinas(professor)));

        
        
        btn_dadosProf.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                Tela_DadosProf.toFront();
            }
          });
        
        btn_disciplinaProf.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                Tela_DisciplinaProf.toFront();
                
            }
    
        });
        
        btn_QuestaoProf.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                Tela_QuestoesProf.toFront();
            }
            
            
        });
        
        
    }

    @FXML
    public void selecionarItems(){
        
        String nome = cb_teste.getSelectionModel().getSelectedItem();
        System.out.println("Nome: " + nome);

        
    }
    
}
