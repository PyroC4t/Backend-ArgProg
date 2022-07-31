package com.portfolioAp.ap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreEdu;
    private String institutoEdu;
    private String tituloEdu;
    private String periodoEdu;
    private String imgEdu;
    
    //Constructores

    public Educacion() {
    }

    public Educacion(String nombreEdu, String institutoEdu, String tituloEdu, String periodoEdu, String imgEdu) {
        this.nombreEdu = nombreEdu;
        this.institutoEdu = institutoEdu;
        this.tituloEdu = tituloEdu;
        this.periodoEdu = periodoEdu;
        this.imgEdu = imgEdu;
    }
    
    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getInstitutoEdu() {
        return institutoEdu;
    }

    public void setInstitutoEdu(String institutoEdu) {
        this.institutoEdu = institutoEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getPeriodoEdu() {
        return periodoEdu;
    }

    public void setPeriodoEdu(String periodoEdu) {
        this.periodoEdu = periodoEdu;
    }

    public String getImgEdu() {
        return imgEdu;
    }

    public void setImgEdu(String imgEdu) {
        this.imgEdu = imgEdu;
    }
    
}
