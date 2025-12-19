package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_logs")
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Many-to-one with ServiceEntry
    @ManyToOne(optional = false)
    @JoinColumn(name = "service_entry_id", nullable = false)
    private ServiceEntry serviceEntry;

    // ✅ Immutable creation timestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime verifiedAt;

    // ✅ No-arg constructor
    public VerificationLog() {
    }

    // ✅ Parameterized constructor (verifiedAt optional)
    public VerificationLog(ServiceEntry serviceEntry) {
        this.serviceEntry = serviceEntry;
        this.verifiedAt = LocalDateTime.now();
    }

    public VerificationLog(ServiceEntry serviceEntry, LocalDateTime verifiedAt) {
        this.serviceEntry = serviceEntry;
        this.verifiedAt = verifiedAt != null ? verifiedAt : LocalDateTime.now();
    }

    // Getters only (immutability intent)

    public Long getId() {
        return id;
    }

    public ServiceEntry getServiceEntry() {
        return serviceEntry;
    }

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }
}
