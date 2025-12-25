package com.example.demo.dto;

public class AuthResponse {

    private String token;

    public AuthResponse() {}

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getBody() {
        return token;
    }

    public void setBody(String token) {
        this.token = token;
    }
}
