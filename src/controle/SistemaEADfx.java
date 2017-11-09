/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Leandro
 */
public class SistemaEADfx extends Application {
    
              
    @Override
    public void start(Stage primaryStage) throws IOException{
        
        /*Método para remover borda do windows*/
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        String caminhoLogin = "/visao/TelaLogin.fxml";
        
        Parent chamadaLogin = FXMLLoader.load(getClass().getResource(caminhoLogin));
        Scene scene = new Scene(chamadaLogin);
        primaryStage.setScene(scene);
        //primaryStage.setMaximized(true);
        primaryStage.show();
      

    }
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
   
    
}
