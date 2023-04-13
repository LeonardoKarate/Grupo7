package com.grupo7.droneFeeder.controller;

import com.grupo7.droneFeeder.erro.DroneExistenteException;
import com.grupo7.droneFeeder.erro.DroneNaoEncontrado;
import com.grupo7.droneFeeder.erro.Erro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe GerenciadorExceptionController.
 */
@ControllerAdvice
public class GerenciadorExceptionController {

  @ExceptionHandler(DroneExistenteException.class)
  public ResponseEntity<Erro> handleRecursoNaoEncontradoException(DroneExistenteException e) {
    return ResponseEntity.status(400).body(new Erro(e.getMessage()));
  }
  
  @ExceptionHandler(DroneNaoEncontrado.class)
  public ResponseEntity<Erro> handleRecursoNaoEncontradoException(DroneNaoEncontrado e) {
    return ResponseEntity.status(404).body(new Erro(e.getMessage()));
  }
}
