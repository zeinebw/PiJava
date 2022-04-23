/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reservation;
import entities.Voyage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyDB;

/**
 *
 * @author hp
 */
public class ReservationService implements IService<Reservation>{
    Connection cnx;

    public ReservationService() {
        cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Reservation t) {
        try {
            /*String req = "insert into voyage(img,destination,description,date_debut,date_fin,prix,promotion,id_agence_id,id_vol_arrive_id,id_vol_dep_id,nb_place_dispo)"
                    + "values( '" + t.getImg() + "','" + t.getDestination() + "',"+ "'" + t.getDescription() + "',"
                    + "" + t.getDateDebut() + "," + t.getDateFin() + "," + t.getPrix() + "," + t.getIdVolDep() + "," + t.getIdVolArrive() + ","
                    + "" + t.getIdAgence() + "," + t.getNbPlaceDispo() + "," + t.getPromotion() + " )";*/
            String req ="insert into reservation(id_utilisateur_id,id_voyage_id) values(?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
         //   Statement st = cnx.createStatement();
       
             
                 ps.setInt(1, t.getIdUtilisateur());
                 ps.setInt(2, t.getIdVoyage());
                  
         ps.executeUpdate();
      
            System.out.println("Reservation ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reservation t) {
        try {
            String req = "update reservation set id_utilisateur_id=?,id_voyage_id=? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            
                 ps.setInt(1 ,t.getId());
                     ps.setInt(3, t.getIdUtilisateur());
                  ps.setInt(2, t.getIdVoyage());
               
            
            ps.executeUpdate();
            System.out.println("Reservation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int t) {
        String request = "DELETE FROM reservation where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setInt(1, t);
            ps.executeUpdate();
            System.out.println("Reservation supprimée");
           
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
    }

    @Override
    public List<Reservation> recuperer() {
        List<Reservation> reservations = new ArrayList<>();
        try {
            String req = "select * from reservation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reservation p = new Reservation();
                 p.setId(rs.getInt("id"));
                 p.setIdUtilisateur(rs.getInt("id_utilisateur_id"));
                 p.setIdVoyage(rs.getInt("id_voyage_id"));
                 
                /* p.setDateFin(rs.getDate("dateFin"));
                 p.setDateDebut(rs.getDate("dateDebut"));*/
             
                       
              /*  p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setAge(rs.getInt("age"));*/
                reservations.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reservations;
    }
  
}
