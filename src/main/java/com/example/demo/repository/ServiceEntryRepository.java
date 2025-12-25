package com.example.demo.repository;

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    List<ServiceEntry> findByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleAndServiceDateBetween(Vehicle vehicle, Date start, Date end);

    List<ServiceEntry> findByGarageAndServiceDateBetween(Garage garage, Date start, Date end);
}
