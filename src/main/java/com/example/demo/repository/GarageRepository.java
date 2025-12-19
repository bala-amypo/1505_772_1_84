package com.example.demo.repository;

import com.example.demo.model.GarageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepository extends JpaRepository<GarageEntity, Long> {
}
