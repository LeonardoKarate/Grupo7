package com.grupo7.DroneFeeder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo7.DroneFeeder.Dto.EntregaDto;
import com.grupo7.DroneFeeder.Entity.Entrega;
import com.grupo7.DroneFeeder.Service.EntregaService;

@RestController
@RequestMapping(value = "/entrega")
public class EntregaController {
  
  @Autowired
  private EntregaService service;

  @PostMapping
  public ResponseEntity<Entrega> create(@RequestBody EntregaDto entrega) {
    Entrega result = service.create(entrega);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @GetMapping
  public ResponseEntity<List<Entrega>> findAll() {
    List<Entrega> results = service.findAll();
    return ResponseEntity.ok(results);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Entrega> findById(@PathVariable Long id) {
    Entrega result = service.findById(id);
    return ResponseEntity.ok(result);
  }

  @PutMapping
  public ResponseEntity<Entrega> update(@RequestBody Entrega entrega) {
    Entrega result = service.update(entrega);
    return ResponseEntity.ok(result);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    String result = service.delete(id);
    return ResponseEntity.ok(result);
  }
}
