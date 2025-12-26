package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
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

    // POST /api/service-entries
    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry e) {
        return service.createServiceEntry(e);
    }

    // GET /api/service-entries/{id}
    @GetMapping("/{id}")
    public ServiceEntry getById(@PathVariable Long id) {
        return service.getEntryById(id);
    }

    // GET /api/service-entries/vehicle/{vehicleId}
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return service.getEntriesForVehicle(vehicleId);
    }

    // GET /api/service-entries/garage/{garageId}
    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getByGarage(@PathVariable Long garageId) {
        return service.getEntriesByGarage(garageId);
    }
}
