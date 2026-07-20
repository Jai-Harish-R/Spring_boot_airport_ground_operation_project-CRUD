package com.example.crew.Repository;

import com.example.crew.Entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrewRepository extends JpaRepository<Crew,Long> {
    Optional<Crew> findFirstByAvailabilityAndSpecializationIgnoreCase(String availability,String specilization);
    Optional<Crew> findByIdAndFlightId(Long id, Long Flight_id);
}
