package com.grupo7.droneFeeder.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe Drone.
 */
@Entity
public class Drone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "entrega_id")
  private Entrega entrega;
  private String latitude;
  private String longitude;
  
  /**
   * Metodo contrutor.
   */
  public Drone(Entrega entrega, String latitude, String longitude) {
    this.entrega = entrega;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Drone() {

  }

  public Entrega getEntrega() {
    return entrega;
  }

  public void setEntrega(Entrega entrega) {
    this.entrega = entrega;
  }

  public long getId() {
    return id;
  }

}
