package com.example.demo.service;

import com.example.demo.model.ServiceEntryEntity;
import com.example.demo.model.VehicleEntity;
import com.example.demo.repository.ServiceEntryRepository;
import java.time.LocalDate;
import java.util.List;

public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository repo;

    public ServiceEntryServiceImpl(ServiceEntryRepository repo) {
        this.repo = repo;
    }

    public ServiceEntryEntity createServiceEntry(ServiceEntryEntity entry) {
        VehicleEntity v = entry.getVehicle();

        if (!v.getActive())
            throw new IllegalArgumentException("active vehicles");

        if (entry.getServiceDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("future");

        List<ServiceEntryEntity> last = repo.findTopByVehicleOrderByOdometerReadingDesc(v);
        if (!last.isEmpty() && entry.getOdometerReading() < last.get(0).getOdometerReading())
            throw new IllegalArgumentException(">=");

        return repo.save(entry);
    }

    public ServiceEntryEntity getEntryById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entry not found"));
    }

    public List<ServiceEntryEntity> getEntriesForVehicle(Long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }

    public List<ServiceEntryEntity> getEntriesByGarage(Long garageId) {
        return repo.findByGarageId(garageId);
    }
}
