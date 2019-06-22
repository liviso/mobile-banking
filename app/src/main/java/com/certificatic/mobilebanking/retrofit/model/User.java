package com.certificatic.mobilebanking.retrofit.model;

public class User {


    private String lastName;

    private String name;

    private String password;

    private String rol;

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