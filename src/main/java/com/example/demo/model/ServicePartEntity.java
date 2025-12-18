package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "service_entry")
public class ServiceEntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private VehicleEntity vehicle;

    @ManyToOne(optional = false)
    private GarageEntity garage;

    private String serviceType;

    @Column(nullable = false)
    private LocalDate serviceDate;

    @Column(nullable = false)
    private Integer odometerReading;

    private String description;

    @Column(nullable = false, updatable = false)
    private Instant recordedAt = Instant.now();

    public Long getId() { return id; }
    public VehicleEntity getVehicle() { return vehicle; }
    public void setVehicle(VehicleEntity vehicle) { this.vehicle = vehicle; }
    public GarageEntity getGarage() { return garage; }
    public void setGarage(GarageEntity garage) { this.garage = garage; }
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public LocalDate getServiceDate() { return serviceDate; }
    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }
    public Integer getOdometerReading() { return odometerReading; }
    public void setOdometerReading(Integer odometerReading) { this.odometerReading = odometerReading; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
