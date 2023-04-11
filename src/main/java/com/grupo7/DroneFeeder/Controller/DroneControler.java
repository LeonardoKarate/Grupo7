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
import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping("/drone")
public class DroneControler {

  @Autowired
  private DroneService service;

  @PostMapping
  public Response createOneDrone(@RequestBody Drone drone) {
    Drone result = service.createOneDrone(drone);
    return Response.status(Response.Status.CREATED).entity(result).build();
  }

  @GetMapping
  public Response getAllDrone() {
    List<Drone> result = service.getAllDrone();
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @GetMapping("/{id}")
  public Response findDrone(@PathVariable long id) {
    Drone result = service.findDrone(id);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @PutMapping("/{id}")
  public Response updateOneDrone(@PathVariable long id, @RequestBody Drone drone) {
    Drone result = service.updateOneDrone(id, drone);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @DeleteMapping("/{id}")
  public Response deleteOneDrone(@PathVariable long id) {
    String result = service.deleteOneDrone(id);
    return Response.status(Response.Status.OK).entity(result).build();
  }
}
