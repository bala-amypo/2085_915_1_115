package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component   // ✅ THIS IS THE FIX
public class JwtUtil {

    private final String secret;
    private final int expirationMinutes;

    public JwtUtil() {
        this.secret = "default-secret";
        this.expirationMinutes = 60;
    }

    // Required by tests
    public JwtUtil(String secret, int expirationMinutes) {
        this.secret = secret;
        this.expirationMinutes = expirationMinutes;
    }

    public String generateToken(Long userId, String email, String role) {
        return email + "-token";
    }
}
