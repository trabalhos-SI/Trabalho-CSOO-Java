/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.AlunoDAOJDBC;
import dao.CoordenadorDAOJDBC;
import dao.ProfessorDAOJDBC;
import dao.ProvaDAOJDBC;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.AlunoHasDisciplina;
import modelo.Disciplina;
import modelo.Professor;
import modelo.Prova;
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
    private AnchorPane Tela_QuestoesProf;
    @FXML
    private AnchorPane Tela_DadosProf;
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
    @FXML
    private Button btn_montar_prova;
    @FXML
    private Button btn_registrar_prova;
    @FXML
    private AnchorPane Tela_registrar_prova;
    @FXML
    private ComboBox<String> cb_disc_registro_prova;
    @FXML
    private TextField txt_bimestre_cadastro;
    @FXML
    private TextField txt_ano_cadastro;
    @FXML
    private TextField txt_semestre_cadastro;
    @FXML
    private TextField txt_nota_cadastro;
    @FXML
    private TextField txt_tipo_cadastro;
    @FXML
    private Button btn_cadastrar_prova;
    @FXML
    private Button btn_cancelar_prova;
    @FXML
    private Button btn_deletar_prova;
    @FXML
    private AnchorPane Tela_deletar_prova;
    @FXML
    private Button btn_excluir_prova;
    @FXML
    private TextField txt_id_prova;
    @FXML
    private Label lb_tel1;
    @FXML
    private Label lbTeste11;
    @FXML
    private Label lb;
    @FXML
    private Label lb_tel11;
    @FXML
    private Label lbTeste111;
    @FXML
    private Label lb_tel111;
    @FXML
    private Label lbTeste1111;
    @FXML
    private Label lb_tel1111;
    @FXML
    private Label lbTeste11111;
    @FXML
    private Button btn_cancelar_excluir_prova;
    @FXML
    private Label lb_tel;
    @FXML
    private Label lbTeste1;
    
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
          });//FIMBTN_DADOSPROF
        
        btn_disciplinaProf.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                Tela_DisciplinaProf.toFront();
            }
        });//FIM BTN_DISCIPLINAPROF
        
        btn_QuestaoProf.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                Tela_QuestoesProf.toFront();
            }  
        });//FIM BTN_QUESTAOPROF
        
        
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
     
                    }// FIM DO ELSE
         
                }// FIM DO ELSE
                
            }//FIM DO HANDLE EVENT
            
        });//FIM BTN_CRIAR_QUESTAO
        
        
        btn_montar_prova.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                  Stage stage = new Stage();
                        Parent root;
                       
                        try{
                            root = FXMLLoader.load(getClass().getResource("/visao/TelaMontarProva.fxml"));
                            //stage.initStyle(StageStyle.TRANSPARENT);
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                            
                        }catch(IOException ex){
                            JOptionPane.showMessageDialog(null, "erro aqui: " + ex);
                        }// FIM DO CATCH
              }
         });//FIM BTN_MONTAR_PROVA
        
        btn_registrar_prova.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                Tela_registrar_prova.toFront();
                CoordenadorDAOJDBC disciplinas = new CoordenadorDAOJDBC();
                cb_disc_registro_prova.setItems(FXCollections.observableArrayList(disciplinas.retornarDisciplinas()));
             }
        });//FIM BTN_REGISTRAR_PROVA
        
        btn_cadastrar_prova.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                Prova prova = new Prova();
                ProvaDAOJDBC salvar = new ProvaDAOJDBC();
                prova.setBimestre(Integer.parseInt(txt_bimestre_cadastro.getText()));
                prova.setAno(Integer.parseInt(txt_ano_cadastro.getText()));
                prova.setSemestre(Integer.parseInt(txt_semestre_cadastro.getText()));
                prova.setNota(Double.parseDouble(txt_nota_cadastro.getText()));
                prova.setTipo(Integer.parseInt(txt_tipo_cadastro.getText()));
                
                CoordenadorDAOJDBC cord = new CoordenadorDAOJDBC();
                int idDisciplina = cord.retornarIdDisciplina(cb_disc_registro_prova.getSelectionModel().getSelectedItem());
       
                salvar.registrarProva(prova, idDisciplina);
                Tela_DadosProf.toFront();
            }
   
        });
        
        btn_cancelar_prova.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Tela_DadosProf.toFront();
            }
   
        });
        
        btn_deletar_prova.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                Tela_deletar_prova.toFront();
            }
    
        });
        
        btn_excluir_prova.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                int numId = Integer.parseInt(txt_id_prova.getText());
                Prova prova = new Prova();
                ProvaDAOJDBC provadao = new ProvaDAOJDBC();
                prova.setIdProva(numId);
                if(provadao.buscarProva(prova) == true){
                    
                    provadao.deletarProva(prova);
                    JOptionPane.showMessageDialog(null, "Prova deletada!");
                    txt_id_prova.setText("");
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Prova Não encontrada!");
                    txt_id_prova.setText("");
                }
            }
     
        });
        
        btn_cancelar_excluir_prova.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                txt_id_prova.setText("");
                Tela_DadosProf.toFront();
            }
            
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
