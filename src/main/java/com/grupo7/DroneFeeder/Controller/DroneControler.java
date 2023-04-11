package com.grupo7.DroneFeeder.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo7.DroneFeeder.Entity.Drone;
import com.grupo7.DroneFeeder.Service.DroneService;

@RestController
@RequestMapping("/drone")
public class DroneControler {

  @Autowired
  private DroneService service;

  @PostMapping
  public Drone createOneDrone(@RequestBody Drone drone) {
    Drone result = service.createOneDrone(drone);
    return result;
  }

  @GetMapping
  public List<Drone> getAllDrone() {
    List<Drone> result = service.getAllDrone();
    return result;
  }

  @GetMapping("/{id}")
  public Drone findDrone(@PathVariable long id) {
    Drone result = service.findDrone(id);
    return result;
  }

  @PutMapping("/{id}")
  public Drone updateOneDrone(@PathVariable long id, @RequestBody Drone drone) {
    Drone result = service.updateOneDrone(id, drone);
    return result;
  }

  @DeleteMapping("/{id}")
  public String deleteOneDrone(@PathVariable long id) {
    return service.deleteOneDrone(id);
  }
}
