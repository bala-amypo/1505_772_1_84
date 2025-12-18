package com.example.demo.service;

import com.example.demo.model.ServicePartEntity;
import java.util.List;

public interface ServicePartService {
    ServicePartEntity createPart(ServicePartEntity part);
    List<ServicePartEntity> getPartsForEntry(Long entryId);
    ServicePartEntity getPartById(Long id);
}
