/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import controllers.HomeController;
import entities.Agence;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import services.IService;
import util.MyDB;
/**
 *
 * @author SAHAR
 */
public class AgenceService implements IService<Agence> {
  Connection cnx;
  public AgenceService (){
  cnx = MyDB.getInstance().getConnection();}
    @Override
    public void ajouter(Agence a) {       
         try {
            String req = "INSERT INTO Agence (libelle_ag,adresse_ag,numtel,img,slogan,description,email_ag)"
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst= cnx.prepareStatement(req) ;
             pst.setString(1, a.getLibelleAg());
             pst.setString(2, a.getAdressseAg());
             pst.setInt(3, a.getNumTel());
             pst.setString(4, a.getImg());
             pst.setString(5, a.getSlogan());
             pst.setString(6,a.getDescription());
             pst.setString(7, a.getEmailAg());      
             pst.executeUpdate();
            System.out.println("Votre agence est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } //To change body of generated methods, choose Tools | Templates.
    }
    
  /*@Override
    public void ajouter(Agence a) {
         try {
       String req="INSERT INTO vol(ville_dep, ville_arrive, date_vol, nb_place,classe)"+"values("+a.getLibelleAg()+"','"+a.getAdressseAg()+"','"+a.getNumTel()+"',"+t.getNbPlace()+",'"+t.getClasse()+"')";
       
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Vol ajouter");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
*/
    @Override
    public void modifier(Agence a) {
 try {
            String req = "update agence set libelle_ag= ?, adresse_ag =?, numtel =? , img =?, Slogan =?, description =?, email_ag =? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, a.getLibelleAg());
            ps.setString(2, a.getAdressseAg());
            ps.setInt(3, a.getNumTel());
            ps.setString(4, a.getImg());
            ps.setString(5, a.getSlogan());
            ps.setString(6,a.getDescription());
            ps.setString(7,a.getEmailAg());
            ps.setInt(8, a.getId());
            ps.executeUpdate();
            System.out.println("Agence modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }


  @Override
    public void supprimer(int id) {
        String request = "DELETE FROM agence where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("agence supprimée");
           
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
       }

    @Override
    public List<Agence> recuperer() {
 List<Agence> agences = new ArrayList<>();
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
            System.err.println(ex.getMessage());
        }
        return agences;
    }
    /*
    
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
    */
}
    

