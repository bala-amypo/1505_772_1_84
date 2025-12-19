package com.example.demo.service;

import com.example.demo.model.GarageEntity;
import java.util.List;

public interface GarageService {

    GarageEntity createGarage(GarageEntity garage);

    GarageEntity getGarageById(Long id);

    List<GarageEntity> getAllGarages();
}
