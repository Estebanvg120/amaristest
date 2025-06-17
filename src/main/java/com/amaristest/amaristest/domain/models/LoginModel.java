package com.amaristest.amaristest.domain.models;

public class LoginModel {

    private String username;

    private String password;

    private String accessToken;

    private String refreshToken;

    public LoginModel() {
    }

    public LoginModel(String username, String password, String accessToken, String refreshToken) {
        this.username = username;
        this.password = password;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
