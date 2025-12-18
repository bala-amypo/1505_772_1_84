package com.example.demo.repository;

import com.example.demo.model.VerificationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VerificationLogRepository extends JpaRepository<VerificationLogEntity, Long> {
    List<VerificationLogEntity> findByServiceEntryId(Long entryId);
}
