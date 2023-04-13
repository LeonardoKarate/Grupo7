package com.grupo7.droneFeeder.service;

import com.grupo7.droneFeeder.entity.Drone;
import com.grupo7.droneFeeder.erro.DroneExistenteException;
import com.grupo7.droneFeeder.erro.DroneNaoEncontrado;
import com.grupo7.droneFeeder.repository.DroneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Classe DroneService.
 */
@Service
public class DroneService {

  @Autowired
  private DroneRepository repository;
  
  /**
   * metodo createOneDrone.
   */
  public Drone createOneDrone(Drone drone) {
    if (drone.getId() != 0) {
      throw new DroneExistenteException();
    }
    Drone result = repository.save(drone); 
    return result;
  }
  
  public List<Drone> getAllDrone() {
    List<Drone> result = repository.findAll();
    return result;
  }
  
  /**
   * metodo findDrone.
   */
  public Drone findDrone(long id) {
    if (this.exiteDrone(id)) {
      Drone result = repository.findById(id).get();
      return result;      
    }
    throw new DroneNaoEncontrado();
  }
  
  /**
   * metodo updateOneDrone.
   */
  public Drone updateOneDrone(long id, Drone drone) {
    if (this.exiteDrone(id)) {
      Drone result = repository.findById(id).get();
      result.setEntrega(drone.getEntrega());
      return repository.save(result);      
    }
    throw new DroneNaoEncontrado();
  }
  
  /**
   * metodo deleteOneDrone.
   */
  public String deleteOneDrone(long id) {
    if (this.exiteDrone(id)) {
      repository.deleteById(id);
      return "drone deletado com sucesso";      
    }
    throw new DroneNaoEncontrado();
  }
  
  public boolean exiteDrone(long id) {
    return repository.existsById(id);
  }
}
