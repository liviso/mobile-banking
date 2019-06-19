package com.certificatic.mobilebanking.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientResponse {

    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("edad")
    @Expose
    private Integer edad;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("genero")
    @Expose
    private String genero;

    /**
     * No args constructor for use in serialization
     *
     */
    public ClientResponse() {
    }

    /**
     *
     * @param nombre
     * @param id
     * @param apellidos
     * @param edad
     * @param genero
     */
    public ClientResponse(String apellidos, Integer edad, Integer id, String nombre, String genero) {
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

    @Override
    public String toString() {
        return "ClientResponse{" +
                "apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}