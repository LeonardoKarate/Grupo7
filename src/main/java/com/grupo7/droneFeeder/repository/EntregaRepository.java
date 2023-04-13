package com.grupo7.droneFeeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo7.droneFeeder.entity.Entrega;

/**
 * interface EntregaRepository.
 */
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
  
}
