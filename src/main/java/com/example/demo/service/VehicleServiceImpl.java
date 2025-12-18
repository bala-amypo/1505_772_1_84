package com.example.demo.service;


import com.example.demo.model.VehicleEntity;
import com.example.demo.repository.VehicleRepository;
import java.util.List;

public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleEntity createVehicle(VehicleEntity vehicle) {
        if (vehicleRepository.findByVin(vehicle.getVin()).isPresent())
            throw new IllegalArgumentException("VIN");
        return vehicleRepository.save(vehicle);
    }

    public VehicleEntity getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    public VehicleEntity getVehicleByVin(String vin) {
        return vehicleRepository.findByVin(vin)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    public List<VehicleEntity> getVehiclesByOwner(Long ownerId) {
        return vehicleRepository.findByOwnerId(ownerId);
    }

    public void deactivateVehicle(Long id) {
        VehicleEntity v = getVehicleById(id);
        v.setActive(false);
        vehicleRepository.save(v);
    }
}
