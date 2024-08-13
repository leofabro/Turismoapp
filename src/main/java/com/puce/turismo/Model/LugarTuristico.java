package com.puce.turismo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lugares_turisticos") // Nombre de la colección en MongoDB
public class LugarTuristico {

    @Id
    private String id; // Cambiar a String para MongoDB

    private String nombre;
    private String descripcion;
    private String imagenes;
    private String estado;
    private String horario;
    private double latitud; 
    private double longitud;

    // Constructor
    public LugarTuristico(String id, String nombre, String descripcion, String imagenes, String estado, String horario, double latitud, double longitud) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.estado = estado;
        this.horario = horario;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Constructor vacío
    public LugarTuristico() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getLatitud() {
        return latitud;
    }
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
