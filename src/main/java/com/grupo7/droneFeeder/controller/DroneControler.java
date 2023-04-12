package com.grupo7.dronefeeder.controller;

import com.grupo7.dronefeeder.entity.Drone;
import com.grupo7.dronefeeder.service.DroneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe DroneControler.
 */
@RestController
@RequestMapping("/drone")
public class DroneControler {

  @Autowired
  private DroneService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Drone createOneDrone(@RequestBody Drone drone) throws Error {
    Drone result = service.createOneDrone(drone);
    return result;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Drone> getAllDrone() {
    List<Drone> result = service.getAllDrone();
    return result;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Drone findDrone(@PathVariable long id) {
    Drone result = service.findDrone(id);
    return result;
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Drone updateOneDrone(@PathVariable long id, @RequestBody Drone drone) {
    Drone result = service.updateOneDrone(id, drone);
    return result;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteOneDrone(@PathVariable long id) {
    String result = service.deleteOneDrone(id);
    return result;
  }
}
