package com.portfolioAp.ap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkilldev {
    @NotBlank
    private String nombreSkidev;
    @NotBlank
    private String porcentajeSkidev;
    @NotBlank
    private String iconSkidev;
    
    //Constructores

    public dtoSkilldev() {
    }

    public dtoSkilldev(String nombreSkidev, String porcentajeSkidev, String iconSkidev) {
        this.nombreSkidev = nombreSkidev;
        this.porcentajeSkidev = porcentajeSkidev;
        this.iconSkidev = iconSkidev;
    }
    
    //Getters & Setters

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
