package com.example.demo.repository;

import com.example.demo.model.VerificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {
    // No extra methods required as per specification
}
