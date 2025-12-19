package com.example.demo.controller;
import jakarta.validation.Valid;
import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garages")
public class GarageController {

    private final GarageService service;

    public GarageController(GarageService service) {
        this.service = service;
    }

    @PostMapping
    public GarageEntity createGarage(@Valid @RequestBody GarageEntity garage) {
        return service.createGarage(garage);
    }

    @GetMapping("/{id}")
    public GarageEntity getGarage(@PathVariable Long id) {
        return service.getGarageById(id);
    }

    @GetMapping
    public List<GarageEntity> getAllGarages() {
        return service.getAllGarages();
    }
}
