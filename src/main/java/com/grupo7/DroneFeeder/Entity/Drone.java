package com.grupo7.DroneFeeder.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String entrega;
  
  public Drone() {
    
  }

  public String getEntrega() {
    return entrega;
  }

  public void setEntrega(String entrega) {
    this.entrega = entrega;
  }

  public long getId() {
    return id;
  }
  
}
