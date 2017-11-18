/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import static dao.AlunoDAOJDBC.aluno;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static visao.TelaLoginController.usuario;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TesteController implements Initializable {
    
    
    @FXML
    private Label lb_1;
    @FXML
    private Button bt_1;
    @FXML
    private Button bt_2;
    @FXML
    private AnchorPane tela_2;
    @FXML
    private AnchorPane tela_1;

        
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lb_1.setText("oi");
        
        
        
        bt_1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            
            
            @Override
            public void handle(ActionEvent event){
                
                tela_1.toFront();
            }
            
            
        });
        
         bt_2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            
            
            @Override
            public void handle(ActionEvent event){
                
                tela_2.toFront();
            }
            
            
        });
    
}

    @FXML
    private void initialize(ActionEvent event) {
    }

}