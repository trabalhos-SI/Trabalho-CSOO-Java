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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaLoginController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private Button btnLogar;
    @FXML
    private PasswordField txtPass;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnLogar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                AlunoDAOJDBC alunoDAO = new AlunoDAOJDBC();
                
                if(alunoDAO.consultarLogin(txtUser.getText(), txtPass.getText()) == null){
                    
                    JOptionPane.showMessageDialog(null, "Usuário Não encontrado");
                    
                }else{
                    
                    Stage stage  new Stage();
                    Parent root = null;
                    
                }
            }
        });{
        
        
        
    }
        
        
        
    }
       
    
}
