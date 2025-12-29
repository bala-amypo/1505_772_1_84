package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {
        // Dummy registration for assignment
        String token = jwtTokenProvider.generateToken(request.getEmail(), "USER", 1L);
        return new AuthResponse(token, 1L, request.getEmail(), "USER");
    }

    @GetMapping("/login")
    public AuthResponse login(@RequestParam String email,
                              @RequestParam String password) {
        String token = jwtTokenProvider.generateToken(email, "USER", 1L);
        return new AuthResponse(token, 1L, email, "USER");
    }
}
