package com.portfolioAp.ap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String descripcionPro;
    @NotBlank
    private String enlacesitePro;
    @NotBlank
    private String enlacerepoPro;
    @NotBlank
    private String imgPro;
    
    //Constructores

    public dtoProyecto() {
    }

    public dtoProyecto(String nombrePro, String descripcionPro, String enlacesitePro, String enlacerepoPro, String imgPro) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.enlacesitePro = enlacesitePro;
        this.enlacerepoPro = enlacerepoPro;
        this.imgPro = imgPro;
    }
    
    //Getters & Setters

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
