/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.FXMLVoyageController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author KING
 */
public class HomeController implements Initializable {
    Parent fxml;

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgViewV;
    
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         FileInputStream inputStream;
        try {
            inputStream = new FileInputStream("src/voyagep.png");
             Image image= new Image(inputStream);
          //   imgViewV = new ImageView(image);
          imgViewV.setFitHeight(120);
          imgViewV.setFitWidth(943);
             imgViewV.setImage(image);
             
            // ScrollPane srollPane =new ScrollPane();
         //    ScrollPane.setContent(imgViewV);
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }    

    @FXML
    private void publicationsListe(MouseEvent event) {
        
        
        try {
            fxml=FXMLLoader.load(getClass().getResource("/interfaces/FXMLPublication.fxml"));
              root.getChildren().removeAll();
              root.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    private void fxAjouterVoy(javafx.scene.input.MouseEvent event) {
          System.out.println("msg tessstttt11");
            System.out.println("msg tessstttt11");
              try {
            Parent parent = FXMLLoader.load(getClass().getResource("/pibuidersjavafx/FXMLAddVoyage.fxml"));
            
            Scene scene= new Scene(parent);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
                  System.out.println("msg tessstttt22");
            stage.show();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficheVoyage(MouseEvent event) {
         try {
            fxml=FXMLLoader.load(getClass().getResource("/interfaces/FXMLVoyage.fxml"));
              root.getChildren().removeAll();
              root.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
}
