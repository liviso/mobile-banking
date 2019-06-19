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
    @SerializedName("sexo")
    @Expose
    private String sexo;

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
     * @param sexo
     */
    public ClientResponse(String apellidos, Integer edad, Integer id, String nombre, String sexo) {
        super();
        this.apellidos = apellidos;
        this.edad = edad;
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "ClientResponse{" +
                "apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}