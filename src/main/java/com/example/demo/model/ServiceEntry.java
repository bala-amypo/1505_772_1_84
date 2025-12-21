package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Many service entries belong to one vehicle
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    // 🔗 Many service entries belong to one garage
    @ManyToOne
    @JoinColumn(name = "garage_id", nullable = false)
    private Garage garage;

    private String serviceType;

    @Temporal(TemporalType.DATE)
    private Date serviceDate;

    private Integer odometerReading;

    private String description;

    private Timestamp recordedAt = new Timestamp(System.currentTimeMillis());

    // 🔗 One service entry → many parts
    @OneToMany(mappedBy = "serviceEntry", cascade = CascadeType.ALL)
    private List<ServicePart> serviceParts;

    // 🔗 One service entry → many verification logs
    @OneToMany(mappedBy = "serviceEntry", cascade = CascadeType.ALL)
    private List<VerificationLog> verificationLogs;

    // ✅ Empty constructor
    public ServiceEntry() {
    }

    // ✅ Parameterized constructor
    public ServiceEntry(Vehicle vehicle, Garage garage, String serviceType,
                        Date serviceDate, Integer odometerReading,
                        String description) {
        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
        this.description = description;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Integer getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getRecordedAt() {
        return recordedAt;
    }
}
