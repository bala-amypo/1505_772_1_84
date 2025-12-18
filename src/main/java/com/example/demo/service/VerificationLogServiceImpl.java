package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.VerificationLogEntity;
import com.example.demo.repository.VerificationLogRepository;
import java.util.List;

public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository repo;

    public VerificationLogServiceImpl(VerificationLogRepository repo) {
        this.repo = repo;
    }

    public VerificationLogEntity createLog(VerificationLogEntity log) {
        return repo.save(log);
    }

    public List<VerificationLogEntity> getLogsForEntry(Long entryId) {
        return repo.findByServiceEntryId(entryId);
    }

    public VerificationLogEntity getLogById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Log not found"));
    }
}
