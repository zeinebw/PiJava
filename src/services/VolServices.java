/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

//import entities.Compagnie;
import entities.Vol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import utile.MyConnection;
import util.MyDB;

/**
 *
 * @author chebb
 */
public class VolServices  implements IService<Vol>{
    Connection cnx;
    
    public VolServices (){
     cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Vol t) {
         try {
       String req="INSERT INTO vol(id_compagnie_id,ville_dep, ville_arrive, date_vol, nb_place,classe)"+"values("+t.getIdCompagnie()+",'"+t.getVilleDep()+"','"+t.getVilleArrive()+"','"+t.getDateVol()+"',"+t.getNbPlace()+",'"+t.getClasse()+"')";
       
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Vol ajouter");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Vol t) {
         try {
            String req = "update Vol set id_compagnie_id = ?,ville_dep= ?, ville_arrive = ?, date_vol = ?, nb_place = ? ,classe= ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getIdCompagnie());
            ps.setString(2, t.getVilleDep());
            ps.setString(3, t.getVilleArrive());
            ps.setString(4, t.getDateVol());
            ps.setInt(5, t.getNbPlace());
             ps.setString(6, t.getClasse());
            ps.setInt(7, t.getId());
            ps.executeUpdate();
            System.out.println("Vol  modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }

    @Override
    public void supprimer(int t) {
           String request = "DELETE FROM Vol where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setInt(1, t);
            ps.executeUpdate();
            System.out.println("Vol Supprimer");
           
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
    }

  
    public List<Vol> Afficher() {
       List<Vol> vol = new ArrayList<>();
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
                vol.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return vol;
    }

    @Override
    public List<Vol> recuperer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
