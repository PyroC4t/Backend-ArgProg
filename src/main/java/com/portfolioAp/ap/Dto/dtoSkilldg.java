package com.portfolioAp.ap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkilldg {
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String porcentajeSkill;
    @NotBlank
    private String imgSkill;
    
    //Constructores

    public dtoSkilldg() {
    }

    public dtoSkilldg(String nombreSkill, String porcentajeSkill, String imgSkill) {
        this.nombreSkill = nombreSkill;
        this.porcentajeSkill = porcentajeSkill;
        this.imgSkill = imgSkill;
    }
    
    //Getters & Setters

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getPorcentajeSkill() {
        return porcentajeSkill;
    }

    public void setPorcentajeSkill(String porcentajeSkill) {
        this.porcentajeSkill = porcentajeSkill;
    }

    public String getImgSkill() {
        return imgSkill;
    }

    public void setImgSkill(String imgSkill) {
        this.imgSkill = imgSkill;
    }
    
    
    
}
