package com.portfolioAp.ap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String empresaExp;
    @NotBlank
    private String cargoExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private String imgExp;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExp, String empresaExp, String cargoExp, String descripcionExp, String imgExp) {
        this.nombreExp = nombreExp;
        this.empresaExp = empresaExp;
        this.cargoExp = cargoExp;
        this.descripcionExp = descripcionExp;
        this.imgExp = imgExp;
    }
    
    //Getters & Setters

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getEmpresaExp() {
        return empresaExp;
    }

    public void setEmpresaExp(String empresaExp) {
        this.empresaExp = empresaExp;
    }

    public String getCargoExp() {
        return cargoExp;
    }

    public void setCargoExp(String cargoExp) {
        this.cargoExp = cargoExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getImgExp() {
        return imgExp;
    }

    public void setImgExp(String imgExp) {
        this.imgExp = imgExp;
    }
    
}
