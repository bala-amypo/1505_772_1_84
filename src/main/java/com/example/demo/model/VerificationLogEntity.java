package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VerificationLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    private ServiceEntryEntity serviceEntry;

    public Long getId() { return id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public ServiceEntryEntity getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntryEntity serviceEntry) { this.serviceEntry = serviceEntry; }
}
