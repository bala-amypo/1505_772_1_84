package com.example.demo.service;

import com.example.demo.model.VerificationLogEntity;
import com.example.demo.repository.VerificationLogRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository repo;

    public VerificationLogServiceImpl(VerificationLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public VerificationLogEntity createLog(VerificationLogEntity log) {
        return repo.save(log);
    }

    @Override
    public List<VerificationLogEntity> getLogsForEntry(Long entryId) {
        return repo.findByServiceEntryId(entryId);
    }

    @Override
    public VerificationLogEntity getLogById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Log not found"));
    }
}
