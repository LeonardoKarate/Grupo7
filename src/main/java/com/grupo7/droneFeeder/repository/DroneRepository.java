package com.grupo7.dronefeeder.repository;

import com.grupo7.dronefeeder.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface DroneRepository.
 */
public interface DroneRepository extends JpaRepository<Drone, Long> {

}
