package com.example.demo.service;

import com.example.demo.model.ServicePartEntity;
import com.example.demo.repository.ServicePartRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository repo;

    public ServicePartServiceImpl(ServicePartRepository repo) {
        this.repo = repo;
    }

    @Override
    public ServicePartEntity createPart(ServicePartEntity part) {
        if (part == null || part.getQuantity() == null || part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        return repo.save(part);
    }

    @Override
    public List<ServicePartEntity> getPartsForEntry(Long entryId) {
        return repo.findByServiceEntryId(entryId);
    }

    @Override
    public ServicePartEntity getPartById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Part not found"));
    }
}
