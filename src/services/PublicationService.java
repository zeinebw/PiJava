/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Publications;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import util.MyDB;

/**
 *
 * @author hp
 */
public class PublicationService implements IService<Publications> {
        Connection cnx;

    public PublicationService() {
        cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Publications t) {
        try {
           

 
      String req = "INSERT INTO publications (titre,description,img,user_id,date_pub) "
                + "VALUES(?,?,?,?,CURRENT_TIMESTAMP)";
              
            
             // + ",datePub =? "
              ;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getDescription());
            ps.setString(3, t.getImg());
             ps.setInt(4, t.getIdUserP());
         //    ps.setDate(5, new Date(622790105000L));
            
        
           //    ps.setDate(4, (Date) t.getDatePub());
            ps.executeUpdate();
         
            System.out.println("publications ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Publications t) {
        try {
            String req = "update publications set titre= ?, description =?, img =?,date_md =CURRENT_TIMESTAMP where id= ?";
            
              
            
             // + ",datePub =? "
              
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getDescription());
            ps.setString(3, t.getImg());
             ps.setInt(4, t.getId());
           //  ps.setDate(5, new Date(622790105000L));
            //   ps.setDate(5, (Date) t.getDatePub());
            ps.executeUpdate();
            System.out.println("publications modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

  @Override
    public void supprimer(int t) {
        String request = "DELETE FROM publications where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setInt(1, t);
            ps.executeUpdate();
            System.out.println("delete publication");
           
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
    }

    @Override
    public List<Publications> recuperer() {
        List<Publications> Publications = new ArrayList<>();
        try {
            String req = "select * from Publications";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Publications p = new Publications();
                p.setId(rs.getInt("id"));
                p.setTitre(rs.getString("Titre"));
                p.setDescription(rs.getString("Description"));
                p.setImg(rs.getString("Img"));
                p.setDatePub(rs.getDate("date_pub"));  
               
                p.setDatePubM(rs.getDate("date_md"));
                p.setIdUserP(rs.getInt("user_id"));
                Publications.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Publications;
    }
}
