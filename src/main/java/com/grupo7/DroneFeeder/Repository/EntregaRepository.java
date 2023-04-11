package com.grupo7.DroneFeeder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo7.DroneFeeder.Entity.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long>{
  
}
