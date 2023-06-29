package com.hotel.hotel.modelo.enums;

public enum Sexo {
  MASCULINO("MASCULINO"),
  FEMENINO("FEMENINO"),
  OTRO("OTRO");

  private final String nombreFormal;
  Sexo(String nombreFormal){
    this.nombreFormal = nombreFormal;
  }

  public String getNombreFormal(){
    return this.nombreFormal;
  }
}
