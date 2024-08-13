package com.puce.turismo.Model;

import org.springframework.data.annotation.Id;

public class Actividad {
    
    @Id
    private String idA;

    private String nombreA;

    // Constructor
    public Actividad(String idA, String nombreA) {
        this.idA = idA;
        this.nombreA = nombreA;
    }

    // Constructor vacío
    public Actividad() {
    }

    public String getIdA() {
        return idA;
    }

    public void setIdA(String idA) {
        this.idA = idA;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }
}
