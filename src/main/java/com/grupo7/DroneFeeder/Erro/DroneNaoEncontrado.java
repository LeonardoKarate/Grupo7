package com.grupo7.DroneFeeder.Erro;

public class DroneNaoEncontrado extends RuntimeException{

  private static String mensagem = "Drone não encontrado";
  
  public DroneNaoEncontrado() {
    super(mensagem);
  }
}
