package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping
    public ServicePart createPart(@RequestBody ServicePart part) {
        return servicePartService.createPart(part);
    }

    @GetMapping("/{id}")
    public ServicePart getPart(@PathVariable Long id) {
        return servicePartService.getPartById(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<ServicePart> getPartsForEntry(@PathVariable Long entryId) {
        return servicePartService.getPartsForEntry(entryId);
    }
}
