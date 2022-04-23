/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import clickitsefer.RandomString;
import entities.Voyage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import services.VoyageService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLUpdateVoyageFinalController implements Initializable {

     private Voyage tt;
    @FXML
    private TextField fxDestination;
    @FXML
    private TextField fxNbPlaceDispo;
    @FXML
    private TextArea fxDescription;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField fxPrix;
    @FXML
    private TextField fxPromotion;
    @FXML
    private DatePicker fxDateDebut;
    @FXML
    private DatePicker fxDateFin;
    @FXML
    private TextField fxIdAgence;
    @FXML
    private TextField fxIdVolDepart;
    @FXML
    private TextField fxIdVolArrive;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      /*  
          FXMLVoyageController f = new FXMLVoyageController();
        Voyage voy=f.Svoyage();
        System.out.println("ssssssssssssssssss"+voy.getDestination());*/
      //  fxDestination.setText (voy.getDestination()); 
    
      
        
     /*  fxDestination.setText(this.tt.getDestination());
        fxDescription.setText(this.tt.getDescription());
       fxPrix.setText(this.tt.getPrix() + "");
       fxPromotion.setText(this.tt.getPromotion()+"");
       fxNbPlaceDispo.setText(this.tt.getNbPlaceDispo()+"");
       fxDateDebut.setValue(this.tt.getDateDebut().toLocalDate());
       fxDateFin.setValue(this.tt.getDateFin().toLocalDate());
       fxIdAgence.setText(this.tt.getIdAgence() + "");
       fxIdVolDepart.setText(this.tt.getIdVolDep()+"");
       fxIdVolArrive.setText(this.tt.getIdVolArrive()+"");*/
       

    
    
    
    
    
    
    
    
    }    
String path;
    @FXML
    private void ajoutImage(MouseEvent event) {
          FileChooser fc=new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg"));
        File f=fc.showOpenDialog(null);
        if(f !=null){
        path=f.getAbsolutePath();
        Image image = new Image(f.toURI().toString(),imageView.getFitWidth(),imageView.getFitHeight(),true,true);
        
        imageView.setImage(image);
    }
    }
String nameImage;
    @FXML
    private void modifierVoyage(MouseEvent event) {
   /*       VoyageService rec= new VoyageService();
      //   int id =Integer.parseInt(fxId.getText()) ;
            String destination = fxDestination.getText();
            String description = fxDescription.getText();
           float prix = Float.parseFloat(fxPrix.getText());
         /*   Date date_debut = Date.parseDate(fxDateDebut.getDate());
           Date date_fin = Date.parseDate(fxDateFin.getDate());
            Date date_debut = null;
           Date date_fin = null;*/
  /*      Date date_debut= Date.valueOf(fxDateDebut.getValue());
        Date date_fin = Date.valueOf(fxDateFin.getValue());
           float promotion = Float.parseFloat(fxPromotion.getText());
            int nb_place_dispo =Integer.parseInt(fxNbPlaceDispo.getText()) ;
            int id_agence_id =Integer.parseInt(fxIdAgence.getText());
            int id_vol_dep_id =Integer.parseInt(fxIdVolDepart.getText());
            int id_vol_arrive_id =Integer.parseInt(fxIdVolArrive.getText());
         
         Voyage R;
           R = new Voyage(120,null,destination,description,date_debut,date_fin,prix,promotion,id_agence_id,id_vol_arrive_id,id_vol_dep_id,nb_place_dispo);
           rec.modifier(R);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Clicki tsefer :: Success Message");
                alert.setHeaderText(null);
                alert.setContentText("Voyage modifié");
                alert.showAndWait();  
             */

         
    }

    @FXML
    private void ack(ActionEvent event) throws IOException {
            Parent page2 = FXMLLoader.load(getClass().getResource("Home.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    private void fxClose(MouseEvent event) {
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
  
}
