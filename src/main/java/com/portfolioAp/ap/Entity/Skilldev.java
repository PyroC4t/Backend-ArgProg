package com.portfolioAp.ap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skilldev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreSkidev;
    private String porcentajeSkidev;
    private String iconSkidev;
    
    //Constructores

    public Skilldev() {
    }

    public Skilldev(String nombreSkidev, String porcentajeSkidev, String iconSkidev) {
        this.nombreSkidev = nombreSkidev;
        this.porcentajeSkidev = porcentajeSkidev;
        this.iconSkidev = iconSkidev;
    }
    
    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSkidev() {
        return nombreSkidev;
    }

    public void setNombreSkidev(String nombreSkidev) {
        this.nombreSkidev = nombreSkidev;
    }

    public String getPorcentajeSkidev() {
        return porcentajeSkidev;
    }

    public void setPorcentajeSkidev(String porcentajeSkidev) {
        this.porcentajeSkidev = porcentajeSkidev;
    }

    public String getIconSkidev() {
        return iconSkidev;
    }

    public void setIconSkidev(String iconSkidev) {
        this.iconSkidev = iconSkidev;
    }
    
    
    
}
