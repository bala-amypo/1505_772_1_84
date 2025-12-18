package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "service_part")
public class ServicePartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private ServiceEntryEntity serviceEntry;

    private String partName;
    private String partNumber;
    private BigDecimal cost;

    @Column(nullable = false)
    private Integer quantity;

    public Long getId() { return id; }
    public ServiceEntryEntity getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntryEntity serviceEntry) { this.serviceEntry = serviceEntry; }
    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }
    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
