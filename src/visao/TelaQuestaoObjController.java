/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.QuestaoDAOJDBC;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javax.swing.JOptionPane;
import modelo.Objetiva;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaQuestaoObjController implements Initializable {

    @FXML
    public TextField txt_assunto;
    @FXML
    public ComboBox<String> check_dificuldade;
    @FXML
    public TextArea txt_questao;
    @FXML
    private TextField txt_alter_a;
    @FXML
    private TextField txt_alter_b;
    @FXML
    private TextField txt_alter_c;
    @FXML
    private TextField txt_alter_d;
    @FXML
    private TextField txt_alter_e;
    @FXML
    private ComboBox<String> check_alt_correta;
    @FXML
    private Button btn_cancelar;
    @FXML
    private Button btn_cadastrar;
    
    private ObservableList<String> observandolista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //COMBOBOX DE DIFICULDADE
        check_dificuldade.setTooltip(new Tooltip("Nível da questão"));
        check_dificuldade.setValue( "" );
        observandolista = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        check_dificuldade.setItems(observandolista);
        //
        
        //COMBOBOX DE ALTERNATIVA CORRETA
        check_alt_correta.setTooltip(new Tooltip("Alternativa correta"));
        check_alt_correta.setValue( "" );
        observandolista = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        check_alt_correta.setItems(observandolista);
        //
        
        
        btn_cadastrar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                QuestaoDAOJDBC questaoOb = new QuestaoDAOJDBC();
                Objetiva obj = new Objetiva();
                obj.setNivel(Integer.parseInt(check_dificuldade.getSelectionModel().getSelectedItem()));
                obj.setAssunto(txt_assunto.getText());
                obj.setEnunciado(txt_questao.getText());
                obj.setTipo(1);
                questaoOb.cadastrarQuestaoObjetiva(obj);
                
                obj.setAlternativaA(txt_alter_a.getText());
                obj.setAlternativaB(txt_alter_b.getText());
                obj.setAlternativaC(txt_alter_c.getText());
                obj.setAlternativaD(txt_alter_d.getText());
                obj.setAlternativaE(txt_alter_e.getText());
                obj.setAlternativaCorreta(Integer.parseInt(check_alt_correta.getSelectionModel().getSelectedItem()));
                obj.setIdQuestao(questaoOb.ultimoIdCadastrado());
                questaoOb.incluirObjetiva(obj);
                
                JOptionPane.showMessageDialog(null, "questao cadastrada");
                
                
            }
    
        });
        
        btn_cancelar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                btn_cancelar.getScene().getWindow().hide();
            }
            
            
        });
        
        
        
    }
    
    
    
    
    public void selecionaNivel(){
        String nome = check_dificuldade.getSelectionModel().getSelectedItem();
        System.out.println(nome);
    }
    
    public void selecionaAlternativaCorreta(){
        String nome = check_alt_correta.getSelectionModel().getSelectedItem();
        System.out.println(nome);       
    }
    
}
