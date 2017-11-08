/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.AlunoDAOJDBC;
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
import javafx.scene.Scene;
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
     * @throws java.io.IOException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        
        btnLogar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                
                AlunoDAOJDBC alunoDAO = new AlunoDAOJDBC();
                
                if(alunoDAO.consultarLogin(txtUser.getText(), txtPass.getText()) == null){
                    
                    JOptionPane.showMessageDialog(null, "Usuário Não encontrado");
                    
                }else{
                    
                    Stage stage = new Stage();
                    String caminhoLogin1 = "/visao/TelaLogin.fxml"; // DEFINIR CAMINHO PARA TELA 1
        
                    Parent chamadaLogin = null;
                    try {
                        chamadaLogin = FXMLLoader.load(getClass().getResource(caminhoLogin1));
                    } catch (IOException ex) {
                        Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(chamadaLogin);
                    stage.setScene(scene);
                    //primaryStage.setMaximized(true);
                    stage.show();
       
                    
                }
            }
        });{
        
        
        
    }
        
        
        
    }
       
    
}
