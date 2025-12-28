package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    // Constructor required by tests (DO NOT REMOVE AuthenticationManager)
    public AuthController(
            UserService userService,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil
    ) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req) {

        User user = new User(
                0L,
                req.getFullName(),
                req.getEmail(),
                req.getPassword(),
                "USER"
        );

        User savedUser = userService.registerUser(user);

        String token = jwtUtil.generateToken(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getRole()
        );

        return ResponseEntity.ok(
                new AuthResponse(
                        token,
                        savedUser.getId(),
                        savedUser.getEmail(),
                        savedUser.getRole()
                )
        );
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {

        User user = userService.findByEmail(req.getEmail());

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(
                new AuthResponse(
                        token,
                        user.getId(),
                        user.getEmail(),
                        user.getRole()
                )
        );
    }
}
