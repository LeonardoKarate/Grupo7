package com.grupo7.DroneFeeder.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo7.DroneFeeder.Entity.Drone;
import com.grupo7.DroneFeeder.Repository.DroneRepository;

@Service
public class DroneService {

  @Autowired
  private DroneRepository repository;
  
  public Drone createOneDrone(Drone drone) {
    Drone result = repository.save(drone); 
    return result;
  }
}
