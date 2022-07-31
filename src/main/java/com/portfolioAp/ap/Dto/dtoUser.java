package com.portfolioAp.ap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoUser {
    @NotBlank
    private String nombreUser;
    @NotBlank
    private String apellidoUser;
    @NotBlank
    private String imgUser;
    
    //Constructores

    public dtoUser() {
    }

    public dtoUser(String nombreUser, String apellidoUser, String imgUser) {
        this.nombreUser = nombreUser;
        this.apellidoUser = apellidoUser;
        this.imgUser = imgUser;
    }
    
    //Getters & Setters

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getApellidoUser() {
        return apellidoUser;
    }

    public void setApellidoUser(String apellidoUser) {
        this.apellidoUser = apellidoUser;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }
    
    
    
}
