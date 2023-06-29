package com.hotel.hotel.modelo.enums;

public enum Estado {
  ACTIVO("Activo"),
  ELIMINADO("Eliminado");

  private final String nombreFormal;

  Estado(String nombreFormal) {
    this.nombreFormal = nombreFormal;
  }

  public String getNombreFormal() {
    return nombreFormal;
  }
}
