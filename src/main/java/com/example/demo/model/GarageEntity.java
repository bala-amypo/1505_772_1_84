package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class GarageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String contactNumber;
    @Column(name = "garagename",unique = true,nullable = false)
    private String garageName;
    private boolean active;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getGarageName() {
        return garageName;
    }
    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public GarageEntity() {
    }
    public GarageEntity(Long id, String address, String contactNumber, String garageName, boolean active) {
        this.id = id;
        this.address = address;
        this.contactNumber = contactNumber;
        this.garageName = garageName;
        this.active = active;
    }

}
