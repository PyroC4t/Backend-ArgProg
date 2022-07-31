package com.portfolioAp.ap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombrePro;
    private String descripcionPro;
    private String enlacesitePro;
    private String enlacerepoPro;
    private String imgPro;
    
    //Constructores

    public Proyecto() {
    }

    public Proyecto(String nombrePro, String descripcionPro, String enlacesitePro, String enlacerepoPro, String imgPro) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.enlacesitePro = enlacesitePro;
        this.enlacerepoPro = enlacerepoPro;
        this.imgPro = imgPro;
    }

   //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getEnlacesitePro() {
        return enlacesitePro;
    }

    public void setEnlacesitePro(String enlacesitePro) {
        this.enlacesitePro = enlacesitePro;
    }

    public String getEnlacerepoPro() {
        return enlacerepoPro;
    }

    public void setEnlacerepoPro(String enlacerepoPro) {
        this.enlacerepoPro = enlacerepoPro;
    }

    public String getImgPro() {
        return imgPro;
    }

    public void setImgPro(String imgPro) {
        this.imgPro = imgPro;
    }
    
    
    
}
