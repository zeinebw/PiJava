/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controllers.HomeController;
import entities.Agence;
import entities.Vol;
import entities.Voyage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyDB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import util.MyDB;

/**
 *
 * @author hp
 */
public class VoyageService implements IService<Voyage>{
   Connection cnx;

    public VoyageService() {
        cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Voyage t) {
        try {
            /*String req = "insert into voyage(img,destination,description,date_debut,date_fin,prix,promotion,id_agence_id,id_vol_arrive_id,id_vol_dep_id,nb_place_dispo)"
                    + "values( '" + t.getImg() + "','" + t.getDestination() + "',"+ "'" + t.getDescription() + "',"
                    + "" + t.getDateDebut() + "," + t.getDateFin() + "," + t.getPrix() + "," + t.getIdVolDep() + "," + t.getIdVolArrive() + ","
                    + "" + t.getIdAgence() + "," + t.getNbPlaceDispo() + "," + t.getPromotion() + " )";*/
            String req ="insert into voyage(img,destination,description,date_debut,date_fin,prix,promotion,id_agence_id,id_vol_arrive_id,id_vol_dep_id,nb_place_dispo) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
         //   Statement st = cnx.createStatement();
         ps.setString(1, t.getImg());
          ps.setString(2, t.getDestination());
            ps.setString(3, t.getDescription());
            ps.setDate(4,t.getDateDebut());
              ps.setDate(5, t.getDateFin());
               ps.setFloat(6, t.getPrix());
                ps.setFloat(7, t.getPromotion());
                 ps.setInt(11, t.getNbPlaceDispo());
                 ps.setInt(8, t.getAgence().getId());
                  ps.setInt(10, t.getIdVolDep());
                   ps.setInt(9, t.getIdVolArrive());
         ps.executeUpdate();
      
            System.out.println("Voyage ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Voyage t) {
        try {
            String req = "update voyage set destination = ?,description = ?,date_fin = ?,date_debut = ?,prix = ?,nb_place_dispo = ?,promotion = ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
         //   ps.setString(1, t.getImg());
            ps.setString(1, t.getDestination());
            ps.setString(2, t.getDescription());
             ps.setDate(3, t.getDateDebut());
              ps.setDate(4, t.getDateFin());
               ps.setFloat(5, t.getPrix());
                ps.setFloat(6, t.getPromotion());
                 ps.setInt(7, t.getNbPlaceDispo());
                /* ps.setInt(8, t.getIdAgence());
                  ps.setInt(9, t.getIdVolDep());
                   ps.setInt(10, t.getIdVolArrive());*/
            ps.setInt(8, t.getId());
            ps.executeUpdate();
            System.out.println("Voyage modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int t) {
        String request = "DELETE FROM voyage where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setInt(1, t);
            ps.executeUpdate();
            System.out.println("Voyage supprimé");
           
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
    }

    @Override
    public List<Voyage> recuperer() {
        List<Voyage> voyages = new ArrayList<>();
        try {
            String req = "select * from voyage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Voyage p = new Voyage();
                 p.setId(rs.getInt("id"));
                 p.setImg(rs.getString("img"));
                 p.setDestination(rs.getString("destination"));
                 p.setDescription(rs.getString("description"));
                 p.setDateFin(rs.getDate("date_fin"));
                 p.setDateDebut(rs.getDate("date_debut"));
              /*  p.setDateFin(null);
                 p.setDateDebut(null);*/
                 p.setPrix(rs.getFloat("prix"));
                 p.setPromotion(rs.getFloat("promotion"));
                 p.setNbPlaceDispo(rs.getInt("nb_place_dispo"));
                 p.setIdAgence(rs.getInt("id_agence_id"));
                 p.setIdVolDep(rs.getInt("id_vol_dep_id"));
                 p.setIdVolArrive(rs.getInt("id_vol_arrive_id"));
                       
              /*  p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setAge(rs.getInt("age"));*/
              FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/xampp/htdocs/PI/public/uploads/"+rs.getString("img"));
         //   inputStream = new FileInputStream("src/voyagep.png");
             Image image= new Image(inputStream);
          //   imgViewV = new ImageView(image);
                   p.setImageP(image);
                       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                voyages.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return voyages;
    }
  /*   public List<Voyage> recuperer() {
        
        List<Voyage> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM Voyage";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Voyage(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getFloat(7),rs.getFloat(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }*/

    public ObservableList<Voyage> refresh() {
 ObservableList<Voyage> Publiste = FXCollections.observableArrayList();
        try {
            String req = "select * from Voyage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Voyage p = new Voyage();
           p.setId(rs.getInt("id"));
                 p.setImg(rs.getString("img"));
                 p.setDestination(rs.getString("destination"));
                 p.setDescription(rs.getString("description"));
                 p.setDateFin(rs.getDate("date_fin"));
                 p.setDateDebut(rs.getDate("date_debut"));
              /*  p.setDateFin(null);
                 p.setDateDebut(null);*/
                 p.setPrix(rs.getFloat("prix"));
                 p.setPromotion(rs.getFloat("promotion"));
                 p.setNbPlaceDispo(rs.getInt("nb_place_dispo"));
                 p.setIdAgence(rs.getInt("id_agence_id"));
                 p.setIdVolDep(rs.getInt("id_vol_dep_id"));
                 p.setIdVolArrive(rs.getInt("id_vol_arrive_id"));
               
                 //
                 FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/xampp/htdocs/PI/public/uploads/"+rs.getString("Img"));
         //   inputStream = new FileInputStream("src/voyagep.png");
             Image image= new Image(inputStream);
          //   imgViewV = new ImageView(image);
                   p.setImageP(image);
                       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
                Publiste.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Publiste;
    }
    
    
    public ObservableList recupererPromo(){
       ObservableList <Voyage> voyages =  FXCollections.observableArrayList();        
        try {
            String req = "select * from voyage v join agence ag on v.id_agence_id=ag.id";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Agence ag1 = new Agence();
                ag1.setId(rs.getInt("id"));
                
                Voyage p = new Voyage();
                 p.setId(rs.getInt("id"));
                 p.setImg(rs.getString("img"));
                 p.setDestination(rs.getString("destination"));
                 p.setDescription(rs.getString("description"));
                 p.setDateFin(rs.getDate("date_fin"));
                 p.setDateDebut(rs.getDate("date_debut"));
              /*  p.setDateFin(null);
                 p.setDateDebut(null);*/
                 p.setPrix(rs.getFloat("prix"));
                 p.setPromotion(rs.getFloat("promotion"));
                 p.setNbPlaceDispo(rs.getInt("nb_place_dispo"));
              //   p.setIdAgence(rs.getInt("id_agence_id"));
                 p.setIdVolDep(rs.getInt("id_vol_dep_id"));
                 p.setIdVolArrive(rs.getInt("id_vol_arrive_id"));
                 p.setAgence(ag1);
              /*  p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setAge(rs.getInt("age"));*/
              FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/xampp/htdocs/PI/public/uploads/"+rs.getString("img"));
         //   inputStream = new FileInputStream("src/voyagep.png");
             Image image= new Image(inputStream);
          //   imgViewV = new ImageView(image);
                   p.setImageP(image);
                       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                //voyages.add(ag1);
                voyages.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return voyages;
    }
    
public List<String> NomAgence() throws SQLException {
        List<String> agences = new ArrayList<>();
        
        
            String query = "select id,libelle_ag from agence";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
             while (rs.next()) {
             // agences.add(rs.getInt("id"));
              agences.add(rs.getString("libelle_ag"));
              
             // System.out.println(events);
             }
        return agences;
    }

 public ObservableList recupererZainebAgence(){
       ObservableList <Agence> agences =  FXCollections.observableArrayList();        
        try {
            String req = "select * from agence";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Agence a = new Agence();
               a.setId(rs.getInt(1));
               a.setLibelleAg(rs.getString("libelle_ag"));
               a.setAdressseAg(rs.getString("adresse_ag"));
               a.setNumTel(rs.getInt("numtel"));
               a.setImg(rs.getString("img"));
               a.setSlogan(rs.getString("slogan"));
               a.setDescription(rs.getString("description"));
               a.setEmailAg(rs.getString("email_ag"));
               
                agences.add(a);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return agences;
    }
 public List<Integer> idVolDep() throws SQLException {
        List<Integer> vols = new ArrayList<>();
        
        
            String query = "select id from vol";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
             while (rs.next()) {
             // agences.add(rs.getInt("id"));
              vols.add(rs.getInt("id"));
              
             // System.out.println(events);
             }
        return vols;
    }
 public ObservableList recupererVol(){
       ObservableList <Vol> vols =  FXCollections.observableArrayList();        
        try {
            String req = "select * from vol";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Vol p = new Vol();
               p.setId(rs.getInt(1));
                p.setIdCompagnie(rs.getInt(2));
                p.setVilleDep(rs.getString("ville_dep"));
                p.setVilleArrive(rs.getString("ville_arrive"));
                p.setDateVol(rs.getString("date_vol"));
                p.setNbPlace(rs.getInt("nb_place"));
                p.setClasse(rs.getString("classe"));
               
                vols.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return vols;
    }
}
