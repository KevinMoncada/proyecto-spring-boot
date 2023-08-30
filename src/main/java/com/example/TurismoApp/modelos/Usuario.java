package com.example.TurismoApp.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    private Integer id;
    private String nombre;
    private String cedula;
    private Integer rol;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String cedula, Integer rol) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }
}
