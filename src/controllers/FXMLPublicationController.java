/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controllers;

import entities.Publications;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import services.PublicationService;


/**
 *
 * @author KING
 */
public class FXMLPublicationController implements Initializable {
    
    private Parent fxml;
    @FXML
    private AnchorPane root;
    
    @FXML
    private TableView<Publications> table;
    
     @FXML
    private TableColumn<Publications,Integer> id;
     
     
     
    @FXML
    private TableColumn<Publications, Date> datePub;

    @FXML
    private TableColumn<Publications, Date> datePubM;

    @FXML
    private TableColumn<Publications, String> description;



    @FXML
    private TableColumn<Publications,Integer> idUserP;

    @FXML
    private TableColumn<Publications, String> img;


    @FXML
    private TableColumn<Publications, String> titre;
    
  

  
    
    
 

     
     
     
     
      PublicationService ps = new PublicationService();
   // System.out.println(ps.recuperer());
 /*   ObservableList<Publications> list = FXCollections.observableArrayList(
    
            new Publications(5555, "lol", "lol", "lol", 57),
             new Publications(5555, "lol", "lol", "lol", 57),
               new Publications(5555, "lol", "lol", "lol", 57)
    
    
    );*/
      
      
     
      
          ObservableList<Publications> list = FXCollections.observableArrayList(
    
            ps.recuperer()
    
    
    );
      
      
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        id.setCellValueFactory(new PropertyValueFactory<Publications,Integer>("id"));
        idUserP.setCellValueFactory(new PropertyValueFactory<Publications,Integer>("idUserP"));
         titre.setCellValueFactory(new PropertyValueFactory<Publications,String>("titre"));
          description.setCellValueFactory(new PropertyValueFactory<Publications,String>("description"));
           img.setCellValueFactory(new PropertyValueFactory<Publications,String>("img"));
  datePub.setCellValueFactory(new PropertyValueFactory<Publications,Date>("datePub"));
   datePubM.setCellValueFactory(new PropertyValueFactory<Publications,Date>("datePubM"));
        
        
        
        table.setItems(list);
        
    }    

    @FXML
    private void fxAjouterPub(javafx.scene.input.MouseEvent event) {
          System.out.println("msg tessstttt11");
            System.out.println("msg tessstttt11");
              try {
            Parent parent = FXMLLoader.load(getClass().getResource("/pibuidersjavafx/FXMLAddPublication.fxml"));
            
            Scene scene= new Scene(parent);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
                  System.out.println("msg tessstttt22");
            stage.show();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void fxClose(javafx.scene.input.MouseEvent event) {
          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void fxRefrech(javafx.scene.input.MouseEvent event) {
      
        try {
            fxml=FXMLLoader.load(getClass().getResource("/pibuidersjavafx/FXMLAddPublication.fxml"));
            root.getChildren().removeAll();
              root.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
             
         
     
    
    }}
    
    
    
    

