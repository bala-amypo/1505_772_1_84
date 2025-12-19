package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServicePartService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    // ✅ Constructor-based DI
    public ServicePartServiceImpl(
            ServicePartRepository servicePartRepository,
            ServiceEntryRepository serviceEntryRepository) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServicePart createPart(ServicePart part) {

        // ✅ Verify parent ServiceEntry exists
        Long entryId = part.getServiceEntry().getId();
        ServiceEntry entry = serviceEntryRepository.findById(entryId)
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        // ✅ Positive quantity
        if (part.getQuantity() == null || part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        part.setServiceEntry(entry);
        return servicePartRepository.save(part);
    }
}
