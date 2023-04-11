package com.grupo7.DroneFeeder.Service;

import java.util.List;
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
  
  public List<Drone> getAllDrone() {
    List<Drone> result = repository.findAll();
    return result;
  }
  
  public Drone findDrone(long id) {
    Drone result = repository.findById(id).get();
    return result;
  }
  
  public Drone updateOneDrone(long id, Drone drone) {
    Drone result = repository.findById(id).get();
    result.setEntrega(drone.getEntrega());
    return repository.save(result);
  }
  
  public String deleteOneDrone(long id) {
    repository.deleteById(id);
    return "drone deletado com sucesso";
  }
}
