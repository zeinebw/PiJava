/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author KING
 */
public class PostLike {

   private int id;
   private Publications idPubL;
   private int idUserL;

    public PostLike() {
    }

    public PostLike(int id, Publications idPubL, int idUserL) {
        this.id = id;
        this.idPubL = idPubL;
        this.idUserL = idUserL;
    }

    public PostLike(Publications idPubL, int idUserL) {
        this.idPubL = idPubL;
        this.idUserL = idUserL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Publications getIdPubL() {
        return idPubL;
    }

    public void setIdPubL(Publications idPubL) {
        this.idPubL = idPubL;
    }

    public int getIdUserL() {
        return idUserL;
    }

    public void setIdUserL(int idUserL) {
        this.idUserL = idUserL;
    }

    @Override
    public String toString() {
        return "PostLike{" + "id=" + id + ", idPubL=" + idPubL + ", idUserL=" + idUserL + '}';
    }



    
}
