/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static java.awt.SystemColor.text;

/**
 *
 * @author SAHAR
 */
public class Agence {
    private int id;
    private String libelleAg;
    private String adressseAg;
    private int numTel;
    private String img;
    private String slogan;
    private String description;
    private String emailAg;
/////zeineb
    public Agence(int id) {
        this.id = id;
    }

    public Agence(String libelleAg) {
        this.libelleAg = libelleAg;
    }
/////zeineb
    public Agence(int id, String libelleAg, String adressseAg, int numTel, String img, String slogan, String description, String emailAg) {
        this.id = id;
        this.libelleAg = libelleAg;
        this.adressseAg = adressseAg;
        this.numTel = numTel;
        this.img = img;
        this.slogan = slogan;
        this.description = description;
        this.emailAg = emailAg;
    }

    public Agence(String libelleAg, String adressseAg, int numTel, String img, String slogan, String description, String emailAg) {
        this.libelleAg = libelleAg;
        this.adressseAg = adressseAg;
        this.numTel = numTel;
        this.img = img;
        this.slogan = slogan;
        this.description = description;
        this.emailAg = emailAg;
    }

    public Agence() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleAg() {
        return libelleAg;
    }

    public void setLibelleAg(String libelleAg) {
        this.libelleAg = libelleAg;
    }

    public String getAdressseAg() {
        return adressseAg;
    }

    public void setAdressseAg(String adressseAg) {
        this.adressseAg = adressseAg;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailAg() {
        return emailAg;
    }

    public void setEmailAg(String emailAg) {
        this.emailAg = emailAg;
    }

    @Override
    public String toString() {
        return "Agence{" + "id=" + id + ", libelleAg=" + libelleAg + ", adressseAg=" + adressseAg + ", numTel=" + numTel + ", img=" + img + ", slogan=" + slogan + ", description=" + description + ", emailAg=" + emailAg + '}';
    }

   
}