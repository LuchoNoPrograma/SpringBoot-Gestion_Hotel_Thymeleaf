package com.hotel.hotel.modelo.dao;

import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Habitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHabitacionDao extends JpaRepository <Habitacion, Long> {
  @Query("""
          SELECT h FROM Habitacion h 
          WHERE h.estado != 'ELIMINADO' AND h.estadoHabitacion = ?1
          ORDER BY h.nroHabitacion
          """)
  List<Habitacion> findAllDistinctEliminadoByEstadoHabitacion(EstadoHabitacion estadoHabitacion);

  @Query("SELECT h FROM Habitacion h WHERE h.estado != 'ELIMINADO'")
  List<Habitacion> findAllDistinctEliminado(Sort sort);
}
