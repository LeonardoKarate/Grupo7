package com.grupo7.droneFeeder.repository;

import com.grupo7.droneFeeder.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface DroneRepository.
 */
public interface DroneRepository extends JpaRepository<Drone, Long> {

}
