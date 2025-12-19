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

        if (repo.findByName(garage.getName()).isPresent()) {
            throw new IllegalArgumentException("Garage name already exists");
        }

        garage.setActive(true);
        return repo.save(garage);
    }

    @Override
    public GarageEntity updateGarage(Long id, GarageEntity garage) {
        GarageEntity existing = getGarageById(id);

        if (garage.getName() != null && !garage.getName().isEmpty()) {
            if (repo.findByName(garage.getName()).isPresent() &&
                !existing.getName().equals(garage.getName())) {
                throw new IllegalArgumentException("Garage name already exists");
            }
            existing.setName(garage.getName());
        }

        return repo.save(existing);
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

    @Override
    public void deactivateGarage(Long id) {
        GarageEntity garage = getGarageById(id);
        garage.setActive(false);
        repo.save(garage);
    }
}
