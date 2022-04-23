/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author hp
 */
public class Reservation {
    private int id;
    private int idUtilisateur;
    private int idVoyage;

    public Reservation(int id, int idUtilisateur, int idVoyage) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.idVoyage = idVoyage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Reservation() {
    }

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public Reservation(int idUtilisateur, int idVoyage) {
        this.idUtilisateur = idUtilisateur;
        this.idVoyage = idVoyage;
    }
    
    
}
