package com.example.demo.service;

import com.example.demo.model.UserEntity;
import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity user);

    UserEntity getUserById(Long id);

    UserEntity getUserByEmail(String email);

    List<UserEntity> getAllUsers();

    void deactivateUser(Long id);
}
