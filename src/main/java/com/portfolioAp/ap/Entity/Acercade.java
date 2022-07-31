package com.portfolioAp.ap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acercade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String tituloAc;
    private String descripcionAc;
    private String linkiAc;
    private String linkgAc;
    private String linklAc;
    private String imgAc;
    
    //Constructores    

    public Acercade() {
    }

    public Acercade(String tituloAc, String descripcionAc, String linkiAc, String linkgAc, String linklAc, String imgAc) {
        this.tituloAc = tituloAc;
        this.descripcionAc = descripcionAc;
        this.linkiAc = linkiAc;
        this.linkgAc = linkgAc;
        this.linklAc = linklAc;
        this.imgAc = imgAc;
    }

    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloAc() {
        return tituloAc;
    }

    public void setTituloAc(String tituloAc) {
        this.tituloAc = tituloAc;
    }

    public String getDescripcionAc() {
        return descripcionAc;
    }

    public void setDescripcionAc(String descripcionAc) {
        this.descripcionAc = descripcionAc;
    }

    public String getLinkiAc() {
        return linkiAc;
    }

    public void setLinkiAc(String linkiAc) {
        this.linkiAc = linkiAc;
    }

    public String getLinkgAc() {
        return linkgAc;
    }

    public void setLinkgAc(String linkgAc) {
        this.linkgAc = linkgAc;
    }

    public String getLinklAc() {
        return linklAc;
    }

    public void setLinklAc(String linklAc) {
        this.linklAc = linklAc;
    }

    public String getImgAc() {
        return imgAc;
    }

    public void setImgAc(String imgAc) {
        this.imgAc = imgAc;
    }
    
    
}
