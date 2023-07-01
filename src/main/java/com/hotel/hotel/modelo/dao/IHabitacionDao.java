package com.hotel.hotel.modelo.dao;

import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Habitacion;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHabitacionDao extends JpaRepository <Habitacion, Long> {
  @Query("""
          SELECT h FROM Habitacion h WHERE h.estadoHabitacion = ?1
          ORDER BY h.nroHabitacion
          """)
  List<Habitacion> findAllByEstadoHabitacion(EstadoHabitacion estadoHabitacion);
}
