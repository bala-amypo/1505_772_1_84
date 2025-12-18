package com.example.demo.service;

import com.example.demo.model.ServiceEntryEntity;
import java.util.List;

public interface ServiceEntryService {
    ServiceEntryEntity createServiceEntry(ServiceEntryEntity entry);
    ServiceEntryEntity getEntryById(Long id);
    List<ServiceEntryEntity> getEntriesForVehicle(Long vehicleId);
    List<ServiceEntryEntity> getEntriesByGarage(Long garageId);
}
