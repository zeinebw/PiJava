/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;


import entities.Publications;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.PublicationService;

/**
 * FXML Controller class
 *
 * @author KING
 */
public class FXMLAddPublicationController implements Initializable {

    @FXML
    private TextField fxTitre;
    @FXML
    private TextArea fxDescription;
    @FXML
    private TextField fxImg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fxAjouter(MouseEvent event) {
        try {
            String titre = fxTitre.getText();
            String description = fxDescription.getText();
            String img = fxImg.getText();
            
            Publications pm = new Publications(199,titre, description, img, 57);
            PublicationService ps = new PublicationService();
            ps.ajouter(pm);
            
           
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root = loader.load();
           
            //Redirection
          // table.getScene().setRoot(root);
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLAddPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void fxAnnuler(MouseEvent event) {
        
         
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
