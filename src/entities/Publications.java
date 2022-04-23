/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



import java.util.Date;

/**
 *
 * @author hp
 * @CascadeOnDelete
 */

public class Publications {
    
    
private int id;
private String titre,description,img;
private Date datePub;
private Date datePubM;
//Commentaire idComment;
private int idUserP;
//PostLike idPostLikes;
//Signaler idSignalers;

    public Publications() {
    }

    public Publications(int id, String titre, String description, String img, Date datePub, Date datePubM, int idUserP) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.img = img;
        this.datePub = datePub;
         this.datePubM = datePubM;
        this.idUserP = idUserP;
    }

    public Publications(String titre, String description, String img, Date datePub, int idUserP) {
        this.titre = titre;
        this.description = description;
        this.img = img;
        this.datePub = datePub;
        this.idUserP = idUserP;
    }

    public Publications(String titre, String description, String img, int idUserP) {
        this.titre = titre;
        this.description = description;
        this.img = img;
        this.idUserP = idUserP;
    }

    public Publications(int id, String titre, String description, String img, int idUserP) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.img = img;
        this.idUserP = idUserP;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDatePub() {
        return datePub;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

    public int getIdUserP() {
        return idUserP;
    }

    public void setIdUserP(int idUserP) {
        this.idUserP = idUserP;
    }

    public Date getDatePubM() {
        return datePubM;
    }

    public void setDatePubM(Date datePubM) {
        this.datePubM = datePubM;
    }

    @Override
    public String toString() {
        return "Publications{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", img=" + img + ", datePub=" + datePub + ", datePubM=" + datePubM + ", idUserP=" + idUserP + '}';
    }

    
    
    







 

    
}
