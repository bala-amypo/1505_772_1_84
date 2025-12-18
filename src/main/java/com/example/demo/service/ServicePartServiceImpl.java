package com.example.demo.service;

import com.example.demo.model.ServicePartEntity;
import com.example.demo.repository.ServicePartRepository;
import java.util.List;

public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository repo;

    public ServicePartServiceImpl(ServicePartRepository repo) {
        this.repo = repo;
    }

    public ServicePartEntity createPart(ServicePartEntity part) {
        if (part.getQuantity() <= 0)
            throw new IllegalArgumentException("Quantity");
        return repo.save(part);
    }

    public List<ServicePartEntity> getPartsForEntry(Long entryId) {
        return repo.findByServiceEntryId(entryId);
    }

    public ServicePartEntity getPartById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Part not found"));
    }
}
