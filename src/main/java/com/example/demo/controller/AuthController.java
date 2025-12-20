package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER
    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // plain for now

        User savedUser = userService.registerUser(user);

        return new AuthResponse(
                "DUMMY_TOKEN",
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        User user = userService.findByEmail(request.getEmail());

        // simple password check (no security yet)
        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        return new AuthResponse(
                "DUMMY_TOKEN",
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
