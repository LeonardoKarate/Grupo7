package com.grupo7.DroneFeeder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
