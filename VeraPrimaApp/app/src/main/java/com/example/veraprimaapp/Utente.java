package com.example.veraprimaapp;

public class Utente {

    private String email;
    private String username;
    private String password;

    public Utente(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}

