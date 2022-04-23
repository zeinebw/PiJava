/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import clickitsefer.RandomString;
import com.jfoenix.controls.JFXComboBox;
import entities.Agence;
import entities.Vol;
import entities.Voyage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.PrefixSelectionComboBox;
import services.VoyageService;
import services.AgenceService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLAddVoyageController implements Initializable {

    @FXML
    private TextField fxDestination;
    @FXML
    private TextArea fxDescription;
    @FXML
    private TextField fxPrix;
    @FXML
    private TextField fxPromotion;
    @FXML
    private TextField fxNbPlaceDispo;
   // private TextField fxIdAgence;
    private TextField fxIdVolDepart;
    @FXML
    private TextField fxIdVolArrive;
    @FXML
    private ImageView imageView;
    @FXML
    private DatePicker fxDateDebut;
    @FXML
    private DatePicker fxDateFin;
    @FXML
    private ComboBox<String> ListIdAg;
   
    @FXML
    private ComboBox<Integer> listIdVolDep;
   

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*List <Agence> agences=new ArrayList<>();
        List<Integer>listeNomAg=new ArrayList<>();
        for(Agence a:agences){
       listeNomAg.add(a.getId());
               System.out.println(listeNomAg);
        
        

    }*/
       try {
            ///clé étranger
            VoyageService rs11 = new VoyageService();
            ListIdAg.setItems(FXCollections.observableArrayList(rs11.NomAgence()));
           System.out.println(ListIdAg);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAddVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
          try {
            ///clé étranger
            VoyageService rs11 = new VoyageService();
            listIdVolDep.setItems(FXCollections.observableArrayList(rs11.idVolDep()));
           System.out.println(listIdVolDep);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAddVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  // listAg.setItems(FXCollections.observableArrayList(listeNomAg));
        // TODO
    }    

   String nameImage;
    @FXML
    private void AjouterVoyage(javafx.scene.input.MouseEvent event) throws FileNotFoundException {
          // Image ig = new Image("src/wrong1.png");
           FileInputStream inputStream;
             inputStream = new FileInputStream("src/wrong1.png");
             Image ig= new Image(inputStream);
          if(fxDestination.getText().equals("")|| fxDescription.getText().equals("")||Float.parseFloat(fxPrix.getText())== 0)
        {
                Notifications notifications=Notifications.create();
               notifications.graphic(new ImageView(ig));
                notifications.text("Veuillez remplir tous les champs");
                notifications.show();
        }
        else if(ctrl()==false){
                Notifications notifications=Notifications.create();
               notifications.graphic(new ImageView(ig));
                notifications.text("date debut ne peux pas etre superieur a date fin");
                notifications.show();
        }
        else 
        {        
//////////////
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
           // int id_agence_id =Integer.parseInt(listAg.getText());
          //  int id_agence_id =Integer.parseInt( ListIdAg.getSelectionModel().getSelectedItem().toString());
          
          VoyageService serEv = new VoyageService();

        ///test
        ObservableList<Agence> events = serEv.recupererZainebAgence();

        int event_index = ListIdAg.getSelectionModel().getSelectedIndex();

        ListIdAg.getSelectionModel().getSelectedItem();

        // Integer ids = idNomEventPromo
        Agence ag = new Agence(events.get(event_index).getId());
          
          
            int id_vol_dep_id =Integer.parseInt(fxIdVolDepart.getText());
            
              ObservableList<Vol> events2 = serEv.recupererVol();

        int event_index2 = listIdVolDep.getSelectionModel().getSelectedIndex();

        listIdVolDep.getSelectionModel().getSelectedItem();

        // Integer ids = idNomEventPromo
        Vol ag2 = new Vol(events2.get(event_index).getId());
            
            int id_vol_arrive_id =Integer.parseInt(fxIdVolArrive.getText());

        //    File image=new File(pa.getText());
            
            RandomString name=new RandomString();
            nameImage = RandomString.getAlphaNumericString(20)+".png";
       
        //  -  String img = fxImg.getText();
          //   Voyage pm =new Voyage("77777","Pariss","Welcome", new Date(1649324168),new Date(1649324168),1200,1,3,78,78,20);
           Voyage pm = new Voyage(nameImage,ag,destination,description,date_debut,date_fin,prix,promotion,id_vol_arrive_id,id_vol_dep_id,nb_place_dispo);
           VoyageService ps = new VoyageService();
         ps.ajouter(pm); 
         
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
///////////////////////////////////////////Farah
  /*  @FXML
        private void AjouterVoyage(ActionEvent event)
    {
       /*
        if(fxDestination.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" First Name Field empty");
        alert.showAndWait();}
        else if(ControleDescriptionDemande()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Description Demande Evenement is not valid");
        alert.showAndWait();  
            
        }
        else if (tfCapacite.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Capacite Field empty");
        alert.showAndWait();}
        else if(ControleCapacite()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Capacite is not valid");
        alert.showAndWait();     
        }
        else if (tfLibelleEvenemet.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Libelle Evenement Field empty");
        alert.showAndWait();}
        else if(ControleLibelleEvenement()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Libelle Evenement is not valid");
        alert.showAndWait();     
        }
        */
        Voyage de=new Voyage();
         
      /*  
        Date mydateDebut=DateDebut.getValue();
        LocalDate mydateFinEvenement=dateFinEvenement.getValue();
        LocalDate mydateDemande=dateDemande.getValue();
       
        de.setDateDebut(null);
        de.setDateFin(null);
        
       
        LocalTime myHeureDebut=HeureDebut.getValue();
        String myFormattedHeureDebut=myHeureDebut.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        de.setHeure_debutEvent(myFormattedHeureDebut);
        
        LocalTime myHeureFin=HeureFin.getValue();
        String myFormattedHeureFin=myHeureFin.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        de.setHeure_finEvent(myFormattedHeureFin);
       
        de.setLibelleEvenement(tfLibelleEvenemet.getText());
        de.setDescription_event(tfDiscriptionEvenement.getText());
        de.setUtilisateur(2);
        de.setDescription_demande(tfDecriptionDemande.getText());
        de.setCapacite(Integer.parseInt(tfCapacite.getText()));
        de.setDestination(2);
        
        
        
        
        
        
         RandomString name=new RandomString();
            
       
         nameImage = RandomString.getAlphaNumericString(20)+".png";
        de.setImage(nameImage);
        Image img3= imageVue.getImage();
   File file = new File("C:/Users/manou/OneDrive/Desktop/PIDEV_CACT/public/upload/image/"+nameImage);
  
  try {
      ImageIO.write(SwingFXUtils.fromFXImage(img3,
              null), "png", file);
    } catch (IOException e) {
     e.printStackTrace();
    }
        ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
        sde.addDemandeEvenement(de);
        System.out.println("ok");
        
        
    }
*/

    @FXML
    private void fxAnnuler(MouseEvent event) {
    }
String path;
    @FXML
    private void AjouterImage(MouseEvent event) {
        
          FileChooser fc=new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Image Files","*.png","*.jpg"));
        File f=fc.showOpenDialog(null);
        if(f !=null){
        path=f.getAbsolutePath();
        Image image = new Image(f.toURI().toString(),imageView.getFitWidth(),imageView.getFitHeight(),true,true);
        
        imageView.setImage(image);
    }}

    @FXML
    private void ack2(ActionEvent event) throws IOException {
             Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));

        Scene scene2 = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    private void ack(ActionEvent event) {
    }

    @FXML
    private void fxClose(MouseEvent event) {
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
      public boolean ctrl()
        {   String d=fxDateDebut.getValue().toString();
            String f=fxDateFin.getValue().toString();
            String[] first=d.split("-");
            String[] last=f.split("-");
            if(Integer.valueOf(first[0])<=Integer.valueOf(last[0])  && Integer.valueOf(first[1])<=Integer.valueOf(last[1]) && Integer.valueOf(first[2])<=Integer.valueOf(last[2]) )
          return true;
         return false;

        }
  
}
