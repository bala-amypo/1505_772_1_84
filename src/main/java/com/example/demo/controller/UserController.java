package com.example.demo.controller;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVaria
