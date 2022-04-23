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
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import services.VoyageService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLUpdateVoyageController implements Initializable {

    @FXML
    private TextField fxDestination;
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
    @FXML
    private TextField fxNbPlaceDispo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FXMLVoyageController f = new FXMLVoyageController();
        Voyage voy=f.Svoyage();
        
        fxDestination.setText (voy.getDestination());
        
        
    }    
String path;
    private void AjouterImage(MouseEvent event) {
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
    private void ModifierVoyage(MouseEvent event) {
        
        
        
            String destination = fxDestination.getText();
            String description = fxDescription.getText();
           float prix = Float.parseFloat(fxPrix.getText());
         /*   Date date_debut = Date.parseDate(fxDateDebut.getDate());
           Date date_fin = Date.parseDate(fxDateFin.getDate());
            Date date_debut = null;
           Date date_fin = null;*/
        Date date_debut= Date.valueOf(fxDateDebut.getValue());
        Date date_fin = Date.valueOf(fxDateFin.getValue());
           float promotion = Float.parseFloat(fxPromotion.getText());
            int nb_place_dispo =Integer.parseInt(fxNbPlaceDispo.getText()) ;
            int id_agence_id =Integer.parseInt(fxIdAgence.getText());
            int id_vol_dep_id =Integer.parseInt(fxIdVolDepart.getText());
            int id_vol_arrive_id =Integer.parseInt(fxIdVolArrive.getText());

        //    File image=new File(pa.getText());
            
            RandomString name=new RandomString();
            nameImage = RandomString.getAlphaNumericString(20)+".png";
       
        //  -  String img = fxImg.getText();
          //   Voyage pm =new Voyage("77777","Pariss","Welcome", new Date(1649324168),new Date(1649324168),1200,1,3,78,78,20);
           Voyage pm = new Voyage(nameImage,destination,description,date_debut,date_fin,prix,promotion,id_agence_id,id_vol_arrive_id,id_vol_dep_id,nb_place_dispo);
           VoyageService ps = new VoyageService();
         ps.modifier(pm); 
         
         //** save imga
         //******* p to imgae
          
           
          Image img3= imageView.getImage();
       //   String path_image;
       //   path_image=pImagePath.getText();
        //   File outputFile = new File("C:/Users/KING/Desktop/ccc");
  //  BufferedImage bImage = SwingFXUtils.fromFXImage(img3, null);
   File file = new File("C:/xampp/htdocs/PI/public/uploads/"+nameImage);
  
  try {
      ImageIO.write(SwingFXUtils.fromFXImage(img3,
              null), "png", file);
    } catch (IOException e) {
     e.printStackTrace();
    }
         
         
         
         //**************************************fin save image
      
        
        
    }
        
        
    }
    

