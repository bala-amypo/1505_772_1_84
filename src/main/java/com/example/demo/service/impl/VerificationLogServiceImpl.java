package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.VerificationLog;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository logRepository;
    private final ServiceEntryRepository entryRepository;

    // ✅ Constructor-based DI
    public VerificationLogServiceImpl(
            VerificationLogRepository logRepository,
            ServiceEntryRepository entryRepository) {
        this.logRepository = logRepository;
        this.entryRepository = entryRepository;
    }

    @Override
    public VerificationLog createLog(VerificationLog log) {

        // ✅ Ensure parent ServiceEntry exists
        Long entryId = log.getServiceEntry().getId();
        ServiceEntry entry = entryRepository.findById(entryId)
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        // ✅ Create new immutable VerificationLog
        VerificationLog newLog = new VerificationLog(
                entry,
                LocalDateTime.now()
        );

        return logRepository.save(newLog);
    }
}
