package com.example.demo.service;

import com.example.demo.model.GarageEntity;
import com.example.demo.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository repo;

    public GarageServiceImpl(GarageRepository repo) {
        this.repo = repo;
    }

    @Override
    public GarageEntity createGarage(GarageEntity garage) {
        if (garage.getName() == null || garage.getName().isEmpty()) {
            throw new IllegalArgumentException("Garage name required");
        }
        return repo.save(garage);
    }

    @Override
    public GarageEntity getGarageById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Garage not found"));
    }

    @Override
    public List<GarageEntity> getAllGarages() {
        return repo.findAll();
    }
}
