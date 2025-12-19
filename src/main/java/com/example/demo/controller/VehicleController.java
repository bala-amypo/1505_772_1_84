package com.example.demo.controller;
import jakarta.validation.Valid;
import com.example.demo.model.VehicleEntity;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public VehicleEntity create(@Valid @RequestBody VehicleEntity v) {
        return service.createVehicle(v);
    }

    @GetMapping("/{id}")
    public VehicleEntity get(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    @GetMapping("/vin/{vin}")
    public VehicleEntity getByVin(@PathVariable String vin) {
        return service.getVehicleByVin(vin);
    }

    @GetMapping("/owner/{ownerId}")
    public List<VehicleEntity> byOwner(@PathVariable Long ownerId) {
        return service.getVehiclesByOwner(ownerId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateVehicle(id);
    }
}
