package com.hotel.hotel.modelo.enums;

public enum Cargo {
  SUPERVISOR("SUPERVISOR"),
  RECEPCIONISTA("RECEPCIONISTA");

  private final String nombreFormal;
  Cargo(String nombreFormal){
    this.nombreFormal = nombreFormal;
  }

  public String getNombreFormal(){
    return this.nombreFormal;
  }
}
