package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        if (garageRepository.findByGarageName(garage.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("already exists");
        }
        garage.setActive(true);
        return garageRepository.save(garage);
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        Garage existing = getGarageById(id);
        if (garage.getGarageName() != null && !garage.getGarageName().isEmpty()) {
            garageRepository.findByGarageName(garage.getGarageName()).ifPresent(g -> {
                if (!g.getId().equals(id)) throw new IllegalArgumentException("already exists");
            });
            existing.setGarageName(garage.getGarageName());
        }
        if (garage.getAddress() != null) {
            existing.setAddress(garage.getAddress());
        }
        return garageRepository.save(existing);
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public void deactivateGarage(Long id) {
        Garage g = getGarageById(id);
        g.setActive(false);
        garageRepository.save(g);
    }
}
