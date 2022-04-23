/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author KING
 */
public class Signaler {
private int id;
private String description;
private int idPubS;
private int idUserS;

    public Signaler() {
    }

    public Signaler(int id, String description, int idPubS, int idUserS) {
        this.id = id;
        this.description = description;
        this.idPubS = idPubS;
        this.idUserS = idUserS;
    }

    public Signaler(String description, int idPubS, int idUserS) {
        this.description = description;
        this.idPubS = idPubS;
        this.idUserS = idUserS;
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

    public int getIdPubS() {
        return idPubS;
    }

    public void setIdPubS(int idPubS) {
        this.idPubS = idPubS;
    }

    public int getIdUserS() {
        return idUserS;
    }

    public void setIdUserS(int idUserS) {
        this.idUserS = idUserS;
    }

    @Override
    public String toString() {
        return "Signaler{" + "id=" + id + ", description=" + description + ", idPubS=" + idPubS + ", idUserS=" + idUserS + '}';
    }




    
}
