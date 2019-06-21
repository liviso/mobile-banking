package com.certificatic.mobilebanking.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("rol")
    @Expose
    private String rol;
    @SerializedName("userId")
    @Expose
    private String userId;

    /**
     * No args constructor for use in serialization
     */
    public User() {
    }

    /**
     * @param lastName
     * @param userId
     * @param name
     * @param rol
     * @param password
     */
    public User(String lastName, String name, String password, String rol, String userId) {
        super();
        this.lastName = lastName;
        this.name = name;
        this.password = password;
        this.rol = rol;
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}