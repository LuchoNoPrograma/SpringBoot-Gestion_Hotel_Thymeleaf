package com.hotel.hotel.modelo.enums;

public enum EstadoCivil {
  SOLTERO("SOLTERO/A"),
  CASADO("CASADO/A"),
  DIVORCIADO("DIVORCIADO/A"),
  VIUDO("VIUDO/A"),
  UNION_LIBRE("UNION LIBRE");
  private final String nombreFormal;
  EstadoCivil(String nombreFormal){
    this.nombreFormal = nombreFormal;
  }

  public String getNombreFormal(){
    return this.nombreFormal;
  }
}
