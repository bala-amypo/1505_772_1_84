package com.example.demo.service;

import com.example.demo.model.VehicleEntity;
import com.example.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repo;

    public VehicleServiceImpl(VehicleRepository repo) {
        this.repo = repo;
    }

    @Override
    public VehicleEntity createVehicle(VehicleEntity v) {
        if (repo.findByVin(v.getVin()).isPresent()) {
            throw new IllegalArgumentException("VIN already exists");
        }
        return repo.save(v);
    }

    @Override
    public VehicleEntity getVehicleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vehicle not found"));
    }

    @Override
    public VehicleEntity getVehicleByVin(String vin) {
        return repo.findByVin(vin)
                .orElseThrow(() -> new NoSuchElementException("Vehicle not found"));
    }

    @Override
    public List<VehicleEntity> getVehiclesByOwner(Long ownerId) {
        return repo.findByOwnerId(ownerId);
    }

    @Override
    public void deactivateVehicle(Long id) {
        VehicleEntity vehicle = getV
