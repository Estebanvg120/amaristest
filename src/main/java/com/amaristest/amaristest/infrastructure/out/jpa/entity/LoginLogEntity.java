package com.amaristest.amaristest.infrastructure.out.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "login_log")
public class LoginLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private LocalDateTime login_time;

    private String accessToken;

    private String refreshToken;

    public LoginLogEntity(Long id, String username, LocalDateTime login_time, String accessToken, String refreshToken) {
        this.id = id;
        this.username = username;
        this.login_time = login_time;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public LoginLogEntity() {
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

    public LocalDateTime getLogin_time() {
        return login_time;
    }

    public void setLogin_time(LocalDateTime login_time) {
        this.login_time = login_time;
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
