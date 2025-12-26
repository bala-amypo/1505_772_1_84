package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {

    private final ServicePartService service;

    public ServicePartController(ServicePartService service) {
        this.service = service;
    }

    // POST /api/service-parts
    @PostMapping
    public ServicePart create(@RequestBody ServicePart part) {
        return service.createPart(part);
    }

    // GET /api/service-parts/{id}
    @GetMapping("/{id}")
    public ServicePart getById(@PathVariable Long id) {
        return service.getPartById(id);
    }

    // GET /api/service-parts/entry/{entryId}
    @GetMapping("/entry/{entryId}")
    public List<ServicePart> getByEntry(@PathVariable Long entryId) {
        return service.getPartsByServiceEntry(entryId);
    }
}
