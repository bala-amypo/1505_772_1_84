package com.example.demo.service;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public UserEntity createUser(UserEntity user) {
        if (repo.findByEmail(user.getEmail()).isPresent())
            throw new IllegalArgumentException("Email already exists");
        return repo.save(user);
    }

    public UserEntity getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public UserEntity getUserByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public List<UserEntity> getAllUsers() {
        return repo.findAll();
    }
}
