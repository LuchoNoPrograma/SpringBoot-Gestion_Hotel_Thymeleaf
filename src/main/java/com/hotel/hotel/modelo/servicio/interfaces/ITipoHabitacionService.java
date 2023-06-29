package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.TipoHabitacion;

import java.util.List;

public interface ITipoHabitacionService {
  TipoHabitacion save(TipoHabitacion tipoHabitacion);
  TipoHabitacion findById(Long id);
  List<TipoHabitacion> findAll();
}
