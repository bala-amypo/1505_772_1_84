package com.example.demo.repository;

import com.example.demo.model.GarageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GarageRepository extends JpaRepository<GarageEntity, Long> {
    Optional<GarageEntity> findByGarageName(String garageName);
}
