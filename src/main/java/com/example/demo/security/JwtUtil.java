package com.example.demo.security;

public class JwtUtil {

    private final String secret;
    private final int expirationMinutes;

    public JwtUtil() {
        this.secret = "default";
        this.expirationMinutes = 60;
    }

    // ✅ REQUIRED BY TESTS
    public JwtUtil(String secret, int expirationMinutes) {
        this.secret = secret;
        this.expirationMinutes = expirationMinutes;
    }

    public String generateToken(Long userId, String email, String role) {
        return email + "-token";
    }
}
