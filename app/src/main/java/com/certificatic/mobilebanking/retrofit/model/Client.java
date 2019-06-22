package com.certificatic.mobilebanking.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Client {


    private String apellidos;

    private Integer edad;

    private Integer id;

    private String nombre;

    private String genero;

    private String direccion;

    /**
     * No args constructor for use in serialization
     *
     */
    public Client() {
    }

    /**
     *
     * @param nombre
     * @param id
     * @param apellidos
     * @param edad
     * @param genero
     */
    public Client(String apellidos, Integer edad, Integer id, String nombre, String genero) {
        super();
        this.apellidos = apellidos;
        this.edad = edad;
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Client{" +
                "apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}