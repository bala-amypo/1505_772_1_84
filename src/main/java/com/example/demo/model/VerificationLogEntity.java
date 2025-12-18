package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "verification_log")
public class VerificationLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private ServiceEntryEntity serviceEntry;

    @Column(nullable = false, updatable = false)
    private Instant verifiedAt = Instant.now();

    @Column(nullable = false)
    private Boolean verifiedBySystem = true;

    private String notes;

    public Long getId() { return id; }
    public ServiceEntryEntity getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntryEntity serviceEntry) { this.serviceEntry = serviceEntry; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
