package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-parts") // ✅ base path per spec
public class ServicePartController {

    private final ServicePartService servicePartService;

    // ✅ Constructor DI
    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    // ✅ Create a new service part
    @PostMapping
    public ServicePart createPart(@Valid @RequestBody ServicePart part) {
        return servicePartService.createPart(part);
    }
}
