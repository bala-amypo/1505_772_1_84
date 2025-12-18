package com.example.demo.repository;

import com.example.demo.model.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findByVin(String vin);
    List<VehicleEntity> findByOwnerId(Long ownerId);
}
