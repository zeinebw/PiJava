/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

//import controllers.FXMLPublicationController;
//import entities.Publications;
import entities.Voyage;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import services.VoyageService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLVoyageController implements Initializable {

    private Parent fxml;
    private AnchorPane root;
    
    @FXML
    private TableView<Voyage> table;
    
     @FXML
    private TableColumn<Voyage,Integer> id;
     
      @FXML
    private TableColumn<Voyage,Integer> id_agence_id;
     
     @FXML
    private TableColumn<Voyage,Integer> id_vol_dep_id; 
     
      @FXML
    private TableColumn<Voyage,Integer> id_vol_arrive_id;
     
    @FXML
    private TableColumn<Voyage, Date> date_debut;

    @FXML
    private TableColumn<Voyage, Date> date_fin;

    @FXML
    private TableColumn<Voyage, String> description;

        @FXML
    private TableColumn<Voyage, String> destination;
        
    @FXML
    private TableColumn<Voyage,Float> prix;

    @FXML
    private TableColumn<Voyage,Float> promotion;
    
    @FXML
    private TableColumn<Voyage, Image> img;
    
     @FXML
    private TableColumn<Voyage, Integer> nb_place_dispo;


    
  
      VoyageService ps = new VoyageService();
   // System.out.println(ps.recuperer());
      ObservableList<Voyage> list = FXCollections.observableArrayList(
    
            ps.recuperer()
    
    
    );
    @FXML
    private AnchorPane CLOSE;
      
      
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //modd
        
   table.setEditable(true);
           destination.setCellFactory(TextFieldTableCell.forTableColumn());
            description.setCellFactory(TextFieldTableCell.forTableColumn());
             prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
              promotion.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
                nb_place_dispo.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
           ///new FloatStringConverter()
        //modd
        id.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("id"));
        destination.setCellValueFactory(new PropertyValueFactory<Voyage,String>("destination"));
          description.setCellValueFactory(new PropertyValueFactory<Voyage,String>("description"));
       //    img.setCellValueFactory(new PropertyValueFactory<Voyage,String>("img"));
  date_debut.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("DateDebut"));
   date_fin.setCellValueFactory(new PropertyValueFactory<Voyage,Date>("DateFin"));
                       prix.setCellValueFactory(new PropertyValueFactory<Voyage,Float>("prix"));
                     promotion.setCellValueFactory(new PropertyValueFactory<Voyage,Float>("promotion"));
         nb_place_dispo.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("nbPlaceDispo"));
          id_vol_dep_id.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("idVolDep"));
           id_vol_arrive_id.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("idVolArrive"));
            id_agence_id.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("idAgence"));


        img.setCellFactory(param -> {
       //Set up the ImageView
       final ImageView imageview = new ImageView();
       imageview.setFitHeight(70);
       imageview.setFitWidth(100);

       //Set up the Table
       TableCell<Voyage, Image> cell = new TableCell<Voyage, Image>() {
           public void updateItem(Image item, boolean empty) {
             if (item != null) {
                  imageview.setImage(item);
             }
           }
        };
        // Attach the imageview to the cell
        cell.setGraphic(imageview);
        return cell;
   });
          
          
     img.setCellValueFactory(new PropertyValueFactory<Voyage, Image>("imageP"));
     table.setItems(list);
        ////////////Modifier
         destination.setOnEditCommit(new EventHandler<CellEditEvent<Voyage, String>>() {
           
            public void handle(CellEditEvent<Voyage, String> event) {
                Voyage tt = event.getRowValue();
                tt.setDestination(event.getNewValue());
          //     VoyageService st = new  VoyageService();
               ps.modifier(tt);
            }});
           description.setOnEditCommit(new EventHandler<CellEditEvent<Voyage, String>>() {
           
            public void handle(CellEditEvent<Voyage, String> event) {
                Voyage tt = event.getRowValue();
                tt.setDescription(event.getNewValue());
          //     VoyageService st = new  VoyageService();
               ps.modifier(tt);

            }});
             prix.setOnEditCommit(new EventHandler<CellEditEvent<Voyage, Float>>() {
           
            public void handle(CellEditEvent<Voyage, Float> event) {
                Voyage tt = event.getRowValue();
                tt.setPrix(event.getNewValue());
          //     VoyageService st = new  VoyageService();
               ps.modifier(tt);

            }});
                promotion.setOnEditCommit(new EventHandler<CellEditEvent<Voyage, Float>>() {
           
            public void handle(CellEditEvent<Voyage, Float> event) {
                Voyage tt = event.getRowValue();
                tt.setPromotion(event.getNewValue());
          //     VoyageService st = new  VoyageService();
               ps.modifier(tt);

            }});
                   nb_place_dispo.setOnEditCommit(new EventHandler<CellEditEvent<Voyage, Integer>>() {
           
            public void handle(CellEditEvent<Voyage, Integer> event) {
                Voyage tt = event.getRowValue();
                tt.setNbPlaceDispo(event.getNewValue());
          //     VoyageService st = new  VoyageService();
               ps.modifier(tt);

            }});
        
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


    private void ack(ActionEvent event) throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("Home.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    private void supprimerVoyage(MouseEvent event) {
         Voyage voy = table.getSelectionModel().getSelectedItem();
           VoyageService ps = new VoyageService();
            ps.supprimer(voy.getId());
    }
    
    
    public Voyage Svoyage(){
 Voyage voyage = table.getSelectionModel().getSelectedItem();
        return voyage;

}

    @FXML
    private void modifierVoyage1(MouseEvent event) {
        
            try {
            Parent parent = FXMLLoader.load(getClass().getResource("/interfaces/FXMLUpdateVoyageFinal.fxml"));
            
            Scene scene= new Scene(parent);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
                  System.out.println("msg tessstttt22");
            stage.show();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLUpdateVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajouterVoyage(MouseEvent event) {
        
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/interfaces/FXMLAddVoyage.fxml"));
            
            Scene scene= new Scene(parent);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
                  System.out.println("msg tessstttt22");
            stage.show();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLAddVoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @FXML
    private void fxClose(MouseEvent event) {
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void refresh(MouseEvent event) {
            list = ps.refresh();
        table.setItems(list);
        
    }
    
}
