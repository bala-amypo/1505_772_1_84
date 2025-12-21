package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "verification_logs")
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_entry_id", nullable = false)
    private ServiceEntry serviceEntry;

    private Timestamp verifiedAt = new Timestamp(System.currentTimeMillis());

    private Boolean verifiedBySystem = true;

    private String notes;

    public VerificationLog() {
    }

    public VerificationLog(ServiceEntry serviceEntry, Boolean verifiedBySystem, String notes) {
        this.serviceEntry = serviceEntry;
        this.verifiedBySystem = verifiedBySystem;
        this.notes = notes;
        this.verifiedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public ServiceEntry getServiceEntry() {
        return serviceEntry;
    }

    public void setServiceEntry(ServiceEntry serviceEntry) {
        this.serviceEntry = serviceEntry;
    }

    public Timestamp getVerifiedAt() {
        return verifiedAt;
    }

    public Boolean getVerifiedBySystem() {
        return verifiedBySystem;
    }

    public void setVerifiedBySystem(Boolean verifiedBySystem) {
        this.verifiedBySystem = verifiedBySystem;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
