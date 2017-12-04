/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.ProfessorDAOJDBC;
import dao.ProvaDAOJDBC;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Discursiva;
import modelo.Objetiva;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaMontarProvaController implements Initializable {

   
    @FXML
    private TableView<Objetiva> tb_objetiva;
    @FXML
    private TableColumn<Objetiva, Integer> col_id_obj;
    @FXML
    private TableColumn<Objetiva, Integer> col_nivel_obj;
    @FXML
    private TableColumn<Objetiva, String> col_enunciado_obj;
    @FXML
    private TableView<Discursiva> tb_discursiva;
    @FXML
    private TableColumn<Discursiva, Integer> col_id_disc;
    @FXML
    private TableColumn<Discursiva, Integer> col_nivel_disc;
    @FXML
    private TableColumn<Discursiva, String> col_enunciado_disc;
    @FXML
    private Button btn_cadastrar_obj;
    @FXML
    private Button btn_cadastrar_disc;
    @FXML
    private Label count_obj;
    @FXML
    private Label count_disc;
    
    public int countObj = 0;
    public int countDisc = 0;
    @FXML
    private AnchorPane pane_principal;
    @FXML
    private Button btn_finalizar;
    @FXML
    private Button btn_voltar;
    @FXML
    private ComboBox<String> cb_idProva;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         ProfessorDAOJDBC professorjdbc;
         professorjdbc = new ProfessorDAOJDBC();
         
        col_id_obj.setCellValueFactory(new PropertyValueFactory("idQuestao"));
        col_nivel_obj.setCellValueFactory(new PropertyValueFactory("nivel"));
        col_enunciado_obj.setCellValueFactory(new PropertyValueFactory("enunciado"));
        tb_objetiva.setItems(FXCollections.observableArrayList(professorjdbc.listarQuestoesObjetivas()));
        
        col_id_disc.setCellValueFactory(new PropertyValueFactory("idQuestao"));
        col_nivel_disc.setCellValueFactory(new PropertyValueFactory("nivel"));
        col_enunciado_disc.setCellValueFactory(new PropertyValueFactory("enunciado"));
        tb_discursiva.setItems(FXCollections.observableArrayList(professorjdbc.listarQuestoesDiscursivas()));
        
        
        //COMBOBOX
        
        ProvaDAOJDBC provajdbc = new ProvaDAOJDBC();
        
        cb_idProva.setTooltip(new Tooltip("Selecione a disciplina"));
        cb_idProva.setValue(" ");
        cb_idProva.setItems(FXCollections.observableArrayList(provajdbc.listarIdProvas()));
        
        
        //SELECIONAR QUESTAO
        tb_objetiva.getSelectionModel().selectedItemProperty().addListener((observable, 
        oldValue, newValue) -> selecionarItemTableObjetiva(newValue));
        
           
        btn_cadastrar_obj.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event) {
                 countObj += 1;
                 count_obj.setText(Integer.toString(countObj));
                 JOptionPane.showMessageDialog(null, "Questao Selecionada");
                 
                 int numIdQuestao = tb_objetiva.getSelectionModel().selectedItemProperty().getValue().getIdQuestao();
                 int numIdProva = Integer.parseInt(cb_idProva.getSelectionModel().getSelectedItem());
                 
                 
                 ProvaDAOJDBC prova = new ProvaDAOJDBC();
                 prova.MontarQuestaoProva(numIdQuestao, numIdProva);
                 
                 
             }
  
        });
        
        btn_cadastrar_disc.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event) {
                 countDisc += 1;
                 count_disc.setText(Integer.toString(countDisc));
                 JOptionPane.showMessageDialog(null, "Questao Selecionada");
                 
                 int numIdQuestao = tb_discursiva.getSelectionModel().selectedItemProperty().getValue().getIdQuestao();
                 int numIdProva = Integer.parseInt(cb_idProva.getSelectionModel().getSelectedItem());
                 
                 ProvaDAOJDBC prova = new ProvaDAOJDBC();
                 prova.MontarQuestaoProva(numIdQuestao, numIdProva);
                 
             }
    
        });
        
        btn_voltar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event) {
                 
                 btn_voltar.getScene().getWindow().hide();
             }
   
        });
        
         
        
    }

        public int selecionarItemTableObjetiva(Objetiva objetiva){
            
            //System.out.println("ID: " + objetiva.getIdQuestao());
            return objetiva.getIdQuestao();
        }    
    
   
    
}
