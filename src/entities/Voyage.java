/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import javafx.scene.image.Image;

/**
 *
 * @author hp
 */
public class Voyage {
     private int id;
    private String img;
    private Image imageP;
    public Agence agence;

    public Voyage(String img, Image imageP, Agence agence, String destination, String description, Date DateDebut, Date DateFin, float prix, float promotion, int idAgence, int idVolArrive, int idVolDep, int nbPlaceDispo) {
        this.img = img;
        this.imageP = imageP;
        this.agence = agence;
        this.destination = destination;
        this.description = description;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.prix = prix;
        this.promotion = promotion;
        this.idAgence = idAgence;
        this.idVolArrive = idVolArrive;
        this.idVolDep = idVolDep;
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public Voyage(int id, String img, Image imageP, Agence agence, String destination, String description, Date DateDebut, Date DateFin, float prix, float promotion, int idAgence, int idVolArrive, int idVolDep, int nbPlaceDispo) {
        this.id = id;
        this.img = img;
        this.imageP = imageP;
        this.agence = agence;
        this.destination = destination;
        this.description = description;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.prix = prix;
        this.promotion = promotion;
        this.idAgence = idAgence;
        this.idVolArrive = idVolArrive;
        this.idVolDep = idVolDep;
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Image getImageP() {
        return imageP;
    }

    public void setImageP(Image imageP) {
        this.imageP = imageP;
    }
    private String destination;
    private String description;
    private Date DateDebut;
    private Date DateFin;
    private float prix;
    private float promotion;
    private int idAgence;
    private int idVolArrive;
    private int idVolDep;
private int nbPlaceDispo;

    public Voyage(int id, String img, String destination, String description, Date DateDebut, Date DateFin, float prix, float promotion, int idAgence, int idVolArrive, int idVolDep, int nbPlaceDispo) {
        this.id = id;
        this.img = img;
        this.destination = destination;
        this.description = description;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.prix = prix;
        this.promotion = promotion;
        this.idAgence = idAgence;
        this.idVolArrive = idVolArrive;
        this.idVolDep = idVolDep;
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public Voyage(String img, String destination, String description, float prix, float promotion, int idAgence, int idVolArrive, int idVolDep, int nbPlaceDispo) {
        this.img = img;
        this.destination = destination;
        this.description = description;
        this.prix = prix;
        this.promotion = promotion;
        this.idAgence = idAgence;
        this.idVolArrive = idVolArrive;
        this.idVolDep = idVolDep;
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public Voyage(String img, String destination, String description, Date DateDebut, Date DateFin, float prix, float promotion, int idAgence, int idVolArrive, int idVolDep, int nbPlaceDispo) {
        this.img = img;
        this.destination = destination;
        this.description = description;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.prix = prix;
        this.promotion = promotion;
        this.idAgence = idAgence;
        this.idVolArrive = idVolArrive;
        this.idVolDep = idVolDep;
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public Voyage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getPromotion() {
        return promotion;
    }

    public void setPromotion(float promotion) {
        this.promotion = promotion;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public int getIdVolArrive() {
        return idVolArrive;
    }

    public void setIdVolArrive(int idVolArrive) {
        this.idVolArrive = idVolArrive;
    }

    public int getIdVolDep() {
        return idVolDep;
    }

    public void setIdVolDep(int idVolDep) {
        this.idVolDep = idVolDep;
    }

    public int getNbPlaceDispo() {
        return nbPlaceDispo;
    }

    public void setNbPlaceDispo(int nbPlaceDispo) {
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public Voyage(String img, Agence agence, String destination, String description, Date DateDebut, Date DateFin, float prix, float promotion, int idVolArrive, int idVolDep, int nbPlaceDispo) {
        this.img = img;
        this.agence = agence;
        this.destination = destination;
        this.description = description;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.prix = prix;
        this.promotion = promotion;
        this.idVolArrive = idVolArrive;
        this.idVolDep = idVolDep;
        this.nbPlaceDispo = nbPlaceDispo;
    }

 

  

    @Override
    public String toString() {
        return "Voyage{" + "id=" + id + ", img=" + img + ", destination=" + destination + ", description=" + description + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", prix=" + prix + ", promotion=" + promotion + ", agence=" + agence.getId() + ", idVolArrive=" + idVolArrive + ", idVolDep=" + idVolDep + ", nbPlaceDispo=" + nbPlaceDispo + '}';
    }

}
