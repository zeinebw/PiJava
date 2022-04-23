/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickitsefer;

import java.io.FileInputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.VoyageService;

/**
 *
 * @author KING
 */
public class ClickiTsefer extends Application {
    
  
    
    @Override
    public void start(Stage stage) throws Exception {
        
     //   Parent root = FXMLLoader.load(getClass().getResource("/interfaces/FXMLUpdateVoyageFinal.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("/interfaces/FXMLAddVoyage.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Home.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
       // stage.resizableProperty().setValue(false);
       // stage.initStyle(StageStyle.UTILITY);
    //   stage.initStyle(StageStyle.UNDECORATED);
       stage.show();
  /*  VoyageService v=new VoyageService();
        System.out.println(v.recuperer());*/
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
