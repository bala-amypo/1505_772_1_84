package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    // ✅ Latest odometer reading for a vehicle
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    // ✅ All entries for a vehicle
    List<ServiceEntry> findByVehicleId(Long vehicleId);

    // ✅ Entries for a garage with minimum odometer constraint
    @Query("""
           SELECT se FROM ServiceEntry se
           WHERE se.garage.id = :garageId
             AND se.odometerReading >= :minOdometer
           """)
    List<ServiceEntry> findByGarageAndMinOdometer(
            @Param("garageId") Long garageId,
            @Param("minOdometer") int minOdometer
    );

    // ✅ Entries for a vehicle within date range
    @Query("""
           SELECT se FROM ServiceEntry se
           WHERE se.vehicle.id = :vehicleId
             AND se.serviceDate BETWEEN :from AND :to
           """)
    List<ServiceEntry> findByVehicleAndDateRange(
            @Param("vehicleId") Long vehicleId,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to
    );
}
