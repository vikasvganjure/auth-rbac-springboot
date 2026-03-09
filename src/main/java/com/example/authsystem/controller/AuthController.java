package com.example.authsystem.controller;

import com.example.authsystem.security.JwtUtil;
import com.example.authsystem.dto.LoginRequest;
import com.example.authsystem.dto.RegisterRequest;
import com.example.authsystem.entity.User;
import com.example.authsystem.entity.Role;
import com.example.authsystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        //user.setRole(Role.USER);
        user.setRole(request.getRole());

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return Map.of("token", token);
    }
}