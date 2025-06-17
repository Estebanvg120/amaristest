package com.amaristest.amaristest.domain.models;

import java.time.LocalDateTime;

public class LoginLogModel {

    private Long id;
    private String username;
    private String access_token;
    private String refresh_token;
    private LocalDateTime login_time;

    public LoginLogModel() {
    }

    public LoginLogModel(Long id, String username, String access_token, String refresh_token, LocalDateTime login_time) {
        this.id = id;
        this.username = username;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.login_time = login_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public LocalDateTime getLogin_time() {
        return login_time;
    }

    public void setLogin_time(LocalDateTime login_time) {
        this.login_time = login_time;
    }
}
