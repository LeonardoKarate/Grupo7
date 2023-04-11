package com.grupo7.DroneFeeder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo7.DroneFeeder.Entity.Drone;

public interface DroneRepository extends JpaRepository<Drone, Long>{

}
