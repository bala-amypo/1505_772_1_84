package com.example.demo.repository;

import com.example.demo.model.ServiceEntryEntity;
import com.example.demo.model.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntryEntity, Long> {
    List<ServiceEntryEntity> findTopByVehicleOrderByOdometerReadingDesc(VehicleEntity vehicle);
    List<ServiceEntryEntity> findByVehicleId(Long vehicleId);
    List<ServiceEntryEntity> findByGarageId(Long garageId);
}
