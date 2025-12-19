package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "service_parts")
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Many-to-one with ServiceEntry
    @ManyToOne(optional = false)
    @JoinColumn(name = "service_entry_id", nullable = false)
    private ServiceEntry serviceEntry;

    @Column(nullable = false)
    private String partName;

    @Column(nullable = false)
    private Integer quantity;

    // ✅ No-arg constructor
    public ServicePart() {
    }

    // ✅ Parameterized constructor
    public ServicePart(ServiceEntry serviceEntry, String partName, Integer quantity) {
        this.serviceEntry = serviceEntry;
        this.partName = partName;
        this.quantity = quantity;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public ServiceEntry getServiceEntry() {
        return serviceEntry;
    }

    public void setServiceEntry(ServiceEntry serviceEntry) {
        this.serviceEntry = serviceEntry;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
