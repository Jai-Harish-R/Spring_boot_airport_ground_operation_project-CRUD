package com.example.fuel.Repository;

import com.example.fuel.Entity.FuelRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuelRepository extends JpaRepository<FuelRequest,Long> {
    Optional<FuelRequest> findFirstByStatus(String status);
    Optional<FuelRequest> findByFlightId(Long flightId);
}
