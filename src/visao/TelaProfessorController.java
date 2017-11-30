/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.AlunoDAOJDBC;
import dao.ProfessorDAOJDBC;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.Action;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.AlunoHasDisciplina;
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
    private TableColumn<AlunoHasDisciplina, String> cl_disciplinaProf;
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

    private final List<Disciplina> listDisciplina = new ArrayList<>();
    @FXML
    private ComboBox<String> cb_teste;
    @FXML
    private TableView<AlunoHasDisciplina> tb_prof;
    @FXML
    private CheckBox check_dis;
    @FXML
    private CheckBox check_ob;
    @FXML
    private Button btn_criar_questao;
    
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
        
        
        btn_criar_questao.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            
            
            @Override
            public void handle(ActionEvent event){
                

                if(check_dis.selectedProperty().getValue() == false && check_ob.selectedProperty().getValue() == false){
                    
                    JOptionPane.showMessageDialog(null, "Por favor, escolha uma das duas opções!");
                }else if(check_dis.selectedProperty().getValue() == true && check_ob.selectedProperty().getValue() == true){
                    
                    JOptionPane.showMessageDialog(null, "Escolha somente uma das opções!");
                }else{
                    
                    if(check_dis.selectedProperty().getValue() == true){
                        
                        check_dis.selectedProperty().setValue(Boolean.FALSE);
                        Stage stage = new Stage();
                        Parent root;
                       
                        try{
                            root = FXMLLoader.load(getClass().getResource("/visao/TelaQuestaoDisc.fxml"));
                            //stage.initStyle(StageStyle.TRANSPARENT);
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                            
                        }catch(IOException ex){
                            JOptionPane.showMessageDialog(null, "erro aqui: " + ex);
                        }// FIM DO CATCH
                        //btnLogar.getScene().getWindow().hide();
                        
                    }else{
                        
                        check_ob.selectedProperty().setValue(Boolean.FALSE);
                        Stage stage = new Stage();
                        Parent root;
                       
                        try{
                            root = FXMLLoader.load(getClass().getResource("/visao/TelaQuestaoObj.fxml"));
                            //stage.initStyle(StageStyle.TRANSPARENT);
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                            
                        }catch(IOException ex){
                            JOptionPane.showMessageDialog(null, "erro aqui: " + ex);
                        }// FIM DO CATCH
                        //btnLogar.getScene().getWindow().hide();              
                        
                        
                        
                    }// FIM DO ELSE
                    
                    
                }// FIM DO ELSE
                
            }//FIM DO HANDLE EVENT
            
        });
        
        
    }

    @FXML
    public void selecionarItems(){
        
        Aluno aluno;
        AlunoDAOJDBC alunojdbc;
        alunojdbc = new AlunoDAOJDBC();       
        aluno = alunojdbc.buscarAluno(usuario);
        
        Professor professor;
        ProfessorDAOJDBC professorjdbc;
        professorjdbc = new ProfessorDAOJDBC();
        professor = professorjdbc.buscarProfessor(usuario);
        AlunoHasDisciplina teste = new AlunoHasDisciplina();
        
        String nome = cb_teste.getSelectionModel().getSelectedItem();
        
        cl_mediaFinalProf.setCellValueFactory(new PropertyValueFactory("mediaFinal"));
        cl_mpProf.setCellValueFactory(new PropertyValueFactory("mediaParcial"));
        cl_disciplinaProf.setCellValueFactory(new PropertyValueFactory("AlunoNome"));
        tb_prof.setItems(FXCollections.observableArrayList(professorjdbc.listarDisciplinaAluno(aluno, nome)));

        
    }
    
}
