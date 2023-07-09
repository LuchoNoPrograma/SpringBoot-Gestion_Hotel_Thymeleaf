package com.hotel.hotel.modelo.enums;

public enum EstadoCliente {
  //Este estado se usa cuando el cliente reservo una habitacion
  RESERVADO("Reservado"),

  //Este estado se usa cuando el cliente esta usando una habitacion
  HUESPED("Huésped"),

  //Este estado se usa cuando el cliente esta ocupando una habitacion
  DESOCUPADO("Desocupado");
  private final String nombreFormal;

  private EstadoCliente(String nombreFormal) {
    this.nombreFormal = nombreFormal;
  }

  public String getNombreFormal() {
    return nombreFormal;
  }
}
