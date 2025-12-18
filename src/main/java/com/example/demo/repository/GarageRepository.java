package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.GarageEntity;

public interface GarageRepository extends JpaRepository<GarageEntity,Long>{
    
}
