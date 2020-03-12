package com.certificatic.mobilebanking.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Client {


    private Integer id;
    private String nombreTitular;
    private String nombreEntidad;
    private String numeroTarjeta;
    private String cvv;
    private String fechaCaudicidad;
    private String marca;

    public Client(Integer id, String nombreTitular, String nombreEntidad, String numeroTarjeta, String cvv, String fechaCaudicidad, String marca) {
        this.id = id;
        this.nombreTitular = nombreTitular;
        this.nombreEntidad = nombreEntidad;
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.fechaCaudicidad = fechaCaudicidad;
        this.marca = marca;
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getFechaCaudicidad() {
        return fechaCaudicidad;
    }

    public void setFechaCaudicidad(String fechaCaudicidad) {
        this.fechaCaudicidad = fechaCaudicidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}