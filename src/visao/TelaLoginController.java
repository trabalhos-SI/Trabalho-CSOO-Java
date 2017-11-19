/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import com.sun.javaws.Main;
import controle.SistemaEADfx;
import dao.AlunoDAO;
import dao.AlunoDAOJDBC;
import dao.UsuarioDAOJDBC;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaLoginController implements Initializable {

    static Usuario usuario;
    
   
    @FXML
     TextField txtUser;
    @FXML
    private Button btnLogar;
    @FXML
     PasswordField txtPass;
    @FXML
    private Button btnSair;
    
    

    public TextField getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(TextField txtUser) {
        this.txtUser = txtUser;
    }

    public PasswordField getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(PasswordField txtPass) {
        this.txtPass = txtPass;
    }

  
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        
        btnLogar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
  
                UsuarioDAOJDBC usuarioDAO = new UsuarioDAOJDBC();
                
                usuario = usuarioDAO.consultarLogin(txtUser.getText(), txtPass.getText());
                
                if(usuario == null){
                 
                    JOptionPane.showMessageDialog(null, "Usuário Não encontrado");
                    txtUser.setText("");
                    txtPass.setText("");
                    
                }else{
     
                    if(usuario.getTipo() == 1){
                        
                        Stage stage = new Stage();
                        Parent root;
                       
                        try{
                            root = FXMLLoader.load(getClass().getResource("/visao/TelaAlunoDesc.fxml"));
                            //stage.initStyle(StageStyle.TRANSPARENT);
                            
                        Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                            
                        }catch(IOException ex){
                            JOptionPane.showMessageDialog(null, "erro aqui: " + ex);
                        }
   
                        btnLogar.getScene().getWindow().hide();
                    }else{
                        
                        //CARREGAR A TELA DO PROFESSOR AQUI!
                        
                    }
   
                }
            }
        });

    
              
        
    }

    @FXML
    private void handle(ActionEvent event) {
        
        System.exit(0);
    }
 
}
