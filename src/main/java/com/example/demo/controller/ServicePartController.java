package com.example.demo.controller;

import com.example.demo.model.ServicePartEntity;
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

    @PostMapping
    public ServicePartEntity create(@RequestBody ServicePartEntity p) {
        return service.createPart(p);
    }

    @GetMapping("/{id}")
    public ServicePartEntity get(@PathVariable Long id) {
        return service.getPartById(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<ServicePartEntity> byEntry(@PathVariable Long entryId) {
        return service.getPartsForEntry(entryId);
    }
}
