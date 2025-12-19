package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-entries") // ✅ base path per spec
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    // ✅ Constructor-based DI
    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // ✅ Create a new service entry
    @PostMapping
    public ServiceEntry createServiceEntry(@Valid @RequestBody ServiceEntry entry) {
        return serviceEntryService.createServiceEntry(entry);
    }

    // ✅ Get service entries by vehicle
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getEntriesForVehicle(@PathVariable Long vehicleId) {
        return serviceEntryService.getEntriesForVehicle(vehicleId);
    }
}
