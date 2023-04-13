package com.grupo7.droneFeeder.erro;

/**
 * Classe DroneExistenteException.
 */
public class DroneExistenteException extends RuntimeException {

  private static String mensagem = "não pode criar drone com id especifico";
  
  public DroneExistenteException() {
    super(mensagem);
  }
}
