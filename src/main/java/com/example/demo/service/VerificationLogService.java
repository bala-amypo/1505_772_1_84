package com.example.demo.service;

import com.example.demo.model.VerificationLogEntity;
import java.util.List;

public interface VerificationLogService {
    VerificationLogEntity createLog(VerificationLogEntity log);
    List<VerificationLogEntity> getLogsForEntry(Long entryId);
    VerificationLogEntity getLogById(Long id);
}
