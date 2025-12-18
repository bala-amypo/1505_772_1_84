package com.example.demo.service;

import com.example.demo.model.VehicleEntity;
import com.example.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleEntity createVehicle(VehicleEntity vehicle) {
        if (vehicle == null || vehicle.getVin() == null) {
            throw new IllegalArgumentException("VIN must not be null");
        }

        if (vehicleRepository.findByVin(vehicle.getVin()).isPresent()) {
            throw new IllegalArgumentException("VIN already exists");
        }

        return vehicleRepository.save(vehicle);
    }

    @Override
    public VehicleEntity getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vehicle not found"));
    }

    @Override
    public VehicleEntity getVehicleByVin(String vin) {
        return vehicleRepository.findByVin(vin)
                .orElseThrow(() -> new NoSuchElementException("Vehicle not found"));
    }

    @Override
    public List<VehicleEntity> getVehiclesByOwner(Long ownerId) {
        return vehicleRepository.findByOwnerId(ownerId);
    }

    @Override
    public void deactivateVehicle(Long id) {
        VehicleEntity v = getVehicleById(id);
        v.setActive(false);
        vehicleRepository.save(v);
    }
}
