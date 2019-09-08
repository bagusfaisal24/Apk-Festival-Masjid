package com.example.bagus.lpmproject.pojo;

/**
 * Created by Bagus on 04/01/2018.
 */

public class DataUser {
    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_user(String id_user) {
        this.id_pengguna = id_pengguna;
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

    private String id_pengguna, username, password;
}
