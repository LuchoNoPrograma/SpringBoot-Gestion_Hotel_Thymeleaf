package com.hotel.hotel.modelo.enums;

public enum EstadoHabitacion {
  DISPONIBLE("Activo"),
  RESERVADO("Reservado"),
  OCUPADO("Ocupado"),
  EN_MANTENIMIENTO("En mantenimiento");

  private final String nombreFormal;

  EstadoHabitacion(String nombreFormal) {
    this.nombreFormal = nombreFormal;
  }

  public String getNombreFormal() {
    return nombreFormal;
  }
}
