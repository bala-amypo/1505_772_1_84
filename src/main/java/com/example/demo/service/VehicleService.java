package com.example.demo.service;

import com.example.demo.model.VehicleEntity;
import java.util.List;

public interface VehicleService {
    VehicleEntity createVehicle(VehicleEntity vehicle);
    VehicleEntity getVehicleById(Long id);
    VehicleEntity getVehicleByVin(String vin);
    List<VehicleEntity> getVehiclesByOwner(Long ownerId);
    void deactivateVehicle(Long id);
}
