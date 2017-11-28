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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaQuestaoObjController implements Initializable {

    @FXML
    private TextField txt_assunto;
    @FXML
    private ComboBox<String> check_dificuldade;
    @FXML
    private TextArea txt_questao;
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
        observandolista = FXCollections.observableArrayList("A", "B", "C", "D", "E");
        check_alt_correta.setItems(observandolista);
        //
        
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
