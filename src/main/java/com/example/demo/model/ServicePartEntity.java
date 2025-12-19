package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ServicePartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partName;
    private Integer quantity;

    @ManyToOne
    private ServiceEntryEntity serviceEntry;

    public Long getId() { return id; }
    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public ServiceEntryEntity getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntryEntity serviceEntry) { this.serviceEntry = serviceEntry; }
}
