package com.portfolioAp.ap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String institutoEdu;
    @NotBlank
    private String tituloEdu;
    @NotBlank
    private String periodoEdu;
    @NotBlank
    private String imgEdu;
    
    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String institutoEdu, String tituloEdu, String periodoEdu, String imgEdu) {
        this.nombreEdu = nombreEdu;
        this.institutoEdu = institutoEdu;
        this.tituloEdu = tituloEdu;
        this.periodoEdu = periodoEdu;
        this.imgEdu = imgEdu;
    }
    
    //Getters & Setters

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
