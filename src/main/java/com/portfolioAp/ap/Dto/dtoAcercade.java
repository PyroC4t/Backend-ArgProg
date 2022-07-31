package com.portfolioAp.ap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAcercade {
    @NotBlank
    private String tituloAc;
    @NotBlank
    private String descripcionAc;
    @NotBlank
    private String linkiAc;
    @NotBlank
    private String linkgAc;
    @NotBlank
    private String linglAc;
    @NotBlank
    private String imgAc;
    
    //Constructores

    public dtoAcercade() {
    }

    public dtoAcercade(String tituloAc, String descripcionAc, String linkiAc, String linkgAc, String linglAc, String imgAc) {
        this.tituloAc = tituloAc;
        this.descripcionAc = descripcionAc;
        this.linkiAc = linkiAc;
        this.linkgAc = linkgAc;
        this.linglAc = linglAc;
        this.imgAc = imgAc;
    }
    
    //Getters & Setters

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

    public String getLinglAc() {
        return linglAc;
    }

    public void setLinglAc(String linglAc) {
        this.linglAc = linglAc;
    }

    public String getImgAc() {
        return imgAc;
    }

    public void setImgAc(String imgAc) {
        this.imgAc = imgAc;
    }
    
    
    
}
