package com.example.demo.service;

import com.example.demo.model.VerificationLogEntity;
import com.example.demo.repository.VerificationLogRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
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
                .orElseThrow(() -> new NoSuchElementException("Log not found"));
    }
}
