package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles") // ✅ base path per spec
public class VehicleController {

    private final VehicleService vehicleService;

    // ✅ Constructor injection
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // ✅ Create vehicle
    @PostMapping
    public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    // ✅ Get vehicle by ID
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // ✅ Get vehicles by owner
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getVehiclesByOwner(@PathVariable Long ownerId) {
        return vehicleService.getVehiclesByOwner(ownerId);
    }

    // ✅ Deactivate vehicle
    @PostMapping("/{id}/deactivate")
    public void deactivateVehicle(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
    }
}
