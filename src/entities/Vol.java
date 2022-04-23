/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author chebb
 */
public class Vol {
       private int id;
    private String villeDep;
    private String villeArrive;
    private String dateVol;
    private int nbPlace;
    private String classe;
    private int idCompagnie;

    public Vol() {
    }

    public Vol(int id, String villeDep, String villeArrive, String dateVol, int nbPlace, String classe, int idCompagnie) {
        this.id = id;
        this.villeDep = villeDep;
        this.villeArrive = villeArrive;
        this.dateVol = dateVol;
        this.nbPlace = nbPlace;
        this.classe = classe;
        this.idCompagnie = idCompagnie;
    }

    public Vol(int idCompagnie,String villeDep, String villeArrive, String dateVol, int nbPlace, String classe) {
        this.villeDep = villeDep;
        this.villeArrive = villeArrive;
        this.dateVol = dateVol;
        this.nbPlace = nbPlace;
        this.classe = classe;
        this.idCompagnie = idCompagnie;
    }

    public Vol(int id) {
this.id=id;
    }

   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVilleDep() {
        return villeDep;
    }

    public void setVilleDep(String villeDep) {
        this.villeDep = villeDep;
    }

    public String getVilleArrive() {
        return villeArrive;
    }

    public void setVilleArrive(String villeArrive) {
        this.villeArrive = villeArrive;
    }

    public String getDateVol() {
        return dateVol;
    }

    public void setDateVol(String dateVol) {
        this.dateVol = dateVol;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getIdCompagnie() {
        return idCompagnie;
    }

    public void setIdCompagnie(int idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    @Override
    public String toString() {
        return "Vol{" + "id=" + id + ", villeDep=" + villeDep + ", villeArrive=" + villeArrive + ", dateVol=" + dateVol + ", nbPlace=" + nbPlace + ", classe=" + classe + ", idCompagnie=" + idCompagnie + '}';
    }
    
}
