package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
public class GarageController {

    private final GarageService service;

    public GarageController(GarageService service) {
        this.service = service;
    }

    // POST /api/garages
    @PostMapping
    public Garage create(@RequestBody Garage garage) {
        return service.createGarage(garage);
    }

    // PUT /api/garages/{id}
    @PutMapping("/{id}")
    public Garage update(@PathVariable Long id, @RequestBody Garage garage) {
        return service.updateGarage(id, garage);
    }

    // GET /api/garages/{id}
    @GetMapping("/{id}")
    public Garage getById(@PathVariable Long id) {
        return service.getGarageById(id);
    }

    // GET /api/garages
    @GetMapping
    public List<Garage> getAll() {
        return service.getAllGarages();
    }

    // PUT /api/garages/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateGarage(id);
    }
}
