package com.grupo7.DroneFeeder.Erro;

public class DroneExistenteException extends RuntimeException{

  private static String mensagem = "não pode criar drone com id especifico";
  
  public DroneExistenteException() {
    super(mensagem);
  }
}
