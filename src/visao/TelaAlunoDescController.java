/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.AlunoDAOJDBC;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelo.Aluno;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaAlunoDescController extends TelaLoginController implements Initializable {

    @FXML
    private Label lbTeste;

    /**
     * Initializes the controller class.
     * @param stage
     */
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         
             
             
        lbTeste.setText("Teste de transferencia de id para outra tela: " + AlunoDAOJDBC.idGeral);
    }    
    
}
