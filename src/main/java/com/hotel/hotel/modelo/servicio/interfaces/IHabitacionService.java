package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

public interface IHabitacionService {
  Habitacion save(Habitacion habitacion);

  Habitacion findById(Long id);

  List<Habitacion> findAllDistinctEliminado(Sort sort);

  List<Habitacion> findAllDistinctEliminadoAndEstadoHabitacion(EstadoHabitacion estadoHabitacion);

  List<Habitacion> findAllHabitacionesWithClientesHuespedes(Sort sort);

  List<Habitacion> habitacionesMasConcurridasByFechaExacta(LocalDate fechaExacta);

  List<Habitacion> findAllHabitacionesWithClientesHuespedesAndEstadoHabitacion(EstadoHabitacion estadoHabitacion);
}
