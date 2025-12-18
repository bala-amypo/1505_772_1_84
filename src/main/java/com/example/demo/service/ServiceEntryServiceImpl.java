package com.example.demo.service;

import com.example.demo.model.ServiceEntryEntity;
import com.example.demo.model.VehicleEntity;
import com.example.demo.repository.ServiceEntryRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository repo;

    public ServiceEntryServiceImpl(ServiceEntryRepository repo) {
        this.repo = repo;
    }

    @Override
    public ServiceEntryEntity createServiceEntry(ServiceEntryEntity entry) {

        VehicleEntity v = entry.getVehicle();

        if (v == null) {

            throw new IllegalArgumentException("Vehicle is required");
        }

        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Service date cannot be in the future");
        }

        List<ServiceEntryEntity> last =
                repo.findTopByVehicleOrderByOdometerReadingDesc(v);

        if (!last.isEmpty() &&
            entry.getOdometerReading() < last.get(0).getOdometerReading()) {
            throw new IllegalArgumentException(
                "Odometer reading must be greater than or equal to last service"
            );
        }

        return repo.save(entry);
    }

    @Override
    public ServiceEntryEntity getEntryById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Entry not found"));
    }

    @Override
    public List<ServiceEntryEntity> getEntriesForVehicle(Long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntryEntity> getEntriesByGarage(Long garageId) {
        return repo.findByGarageId(garageId);
    }
}
