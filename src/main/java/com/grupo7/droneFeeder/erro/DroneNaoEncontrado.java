package com.grupo7.droneFeeder.erro;

/**
 * Classe DroneNaoEncontrado.
 */
public class DroneNaoEncontrado extends RuntimeException {

  private static String mensagem = "Drone não encontrado";
  
  public DroneNaoEncontrado() {
    super(mensagem);
  }
}
