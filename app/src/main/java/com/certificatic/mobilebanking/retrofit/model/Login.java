package com.certificatic.mobilebanking.retrofit.model;

public class Login {


    private String password;

    private String userId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Login() {
    }

    /**
     *
     * @param userId
     * @param password
     */
    public Login(String password, String userId) {
        super();
        this.password = password;
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}