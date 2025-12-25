package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JwtUtil {

    public String generateToken(Long userId, String email, String role) {
        return UUID.randomUUID().toString();
    }

    public String extractEmail(String token) {
        return null;
    }

    public String extractRole(String token) {
        return null;
    }

    public Long extractUserId(String token) {
        return null;
    }

    public boolean validateToken(String token) {
        return token != null;
    }
}
