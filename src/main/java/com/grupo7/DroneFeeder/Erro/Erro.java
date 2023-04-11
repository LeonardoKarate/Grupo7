package com.grupo7.DroneFeeder.Erro;

import javax.net.ssl.SSLEngineResult.Status;

public class Erro {

  private Status status;
  private String mensagem;
  
  public Erro(Status status, String mensagem) {
    this.status = status;
    this.mensagem = mensagem;
  }
}
