/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javax.swing.ScrollPaneConstants;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaQuestaoDiscController implements Initializable {

    @FXML
    private TextArea txt_resposta;
    @FXML
    private Button btn_cadastrar;
    @FXML
    private Button btn_cancelar;
    @FXML
    private TextArea txt_questao;
    @FXML
    private ComboBox<String> check_dificuldade;
    @FXML
    private TextField txt_assunto;
    @FXML
    private Label lb_teste;
    
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
        
        
        
        btn_cadastrar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                
            }
  
        });
        
    
 
    }    

    
    public void selecionaNivel(){
        String nome = check_dificuldade.getSelectionModel().getSelectedItem();
        System.out.println(nome);
    }
    
}
