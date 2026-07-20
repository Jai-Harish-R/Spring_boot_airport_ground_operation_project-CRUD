package com.example.baggage_system_project.Repository;

import com.example.baggage_system_project.Entity.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaggageRepository extends JpaRepository<Baggage,Long> {
}
