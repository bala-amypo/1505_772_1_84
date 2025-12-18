package com.example.demo.controller;

import com.example.demo.model.ServiceEntryEntity;
import com.example.demo.service.ServiceEntryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService service;

    public ServiceEntryController(ServiceEntryService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceEntryEntity create(@RequestBody ServiceEntryEntity e) {
        return service.createServiceEntry(e);
    }

    @GetMapping("/{id}")
    public ServiceEntryEntity get(@PathVariable Long id) {
        return service.getEntryById(id);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntryEntity> byVehicle(@PathVariable Long vehicleId) {
        return service.getEntriesForVehicle(vehicleId);
    }

    @GetMapping("/garage/{garageId}")
    public List<ServiceEntryEntity> byGarage(@PathVariable Long garageId) {
        return service.getEntriesByGarage(garageId);
    }
}
