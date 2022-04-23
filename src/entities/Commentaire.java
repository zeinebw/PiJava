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
 */
public class Commentaire {

private int id;
private String description;
private Date dateCmtr;
private Publications idPubC;
private int idUserC;

    public Commentaire() {
    }

    public Commentaire(int id, String description, Date dateCmtr, Publications idPubC, int idUserC) {
        this.id = id;
        this.description = description;
        this.dateCmtr = dateCmtr;
        this.idPubC = idPubC;
        this.idUserC = idUserC;
    }

    public Commentaire(String description, Date dateCmtr, Publications idPubC, int idUserC) {
        this.description = description;
        this.dateCmtr = dateCmtr;
        this.idPubC = idPubC;
        this.idUserC = idUserC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCmtr() {
        return dateCmtr;
    }

    public void setDateCmtr(Date dateCmtr) {
        this.dateCmtr = dateCmtr;
    }

    public Publications getIdPubC() {
        return idPubC;
    }

    public void setIdPubC(Publications idPubC) {
        this.idPubC = idPubC;
    }

    public int getIdUserC() {
        return idUserC;
    }

    public void setIdUserC(int idUserC) {
        this.idUserC = idUserC;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", description=" + description + ", dateCmtr=" + dateCmtr + ", idPubC=" + idPubC + ", idUserC=" + idUserC + '}';
    }



    
}
