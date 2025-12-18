package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.GarageEntity;
@Service
public interface GarageService {
    GarageEntity create(GarageEntity ge);
    List<GarageEntity> getall();
    Optional<GarageEntity> getbyid(Long id);
    void delete(Long id);
}
