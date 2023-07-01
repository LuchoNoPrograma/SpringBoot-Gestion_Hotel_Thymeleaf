package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IHabitacionService {
  Habitacion save(Habitacion habitacion);

  Habitacion findById(Long id);

  List<Habitacion> findAll(Sort sort);

  List<Habitacion> findAllByEstadoHabitacion(EstadoHabitacion estadoHabitacion);
}
