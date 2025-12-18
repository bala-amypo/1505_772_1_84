package com.example.demo.repository;

import com.example.demo.model.ServicePartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServicePartRepository extends JpaRepository<ServicePartEntity, Long> {
    List<ServicePartEntity> findByServiceEntryId(Long entryId);
}
