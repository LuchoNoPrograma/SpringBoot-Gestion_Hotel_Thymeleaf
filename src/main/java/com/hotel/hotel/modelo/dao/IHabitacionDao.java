package com.hotel.hotel.modelo.dao;

import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IHabitacionDao extends JpaRepository<Habitacion, Long> {
  @Query("""
          SELECT h FROM Habitacion h 
          WHERE h.estado != 'ELIMINADO' AND h.estadoHabitacion = ?1
          ORDER BY h.nroHabitacion
          """)
  List<Habitacion> findAllDistinctEliminadoByEstadoHabitacion(EstadoHabitacion estadoHabitacion);

  @Query("SELECT h FROM Habitacion h WHERE h.estado != 'ELIMINADO'")
  List<Habitacion> findAllDistinctEliminado(Sort sort);

  @Query(value = """
          SELECT h.*, COUNT(c.id_cliente) AS nClientes
          FROM habitacion h
          LEFT JOIN cliente c ON h.id_habitacion = c.habitacion_id_habitacion
          WHERE ?1 BETWEEN DATE(c.fecha_ingreso) AND DATE(c.fecha_salida)
          GROUP BY h.id_habitacion
          ORDER BY nClientes DESC
             """, nativeQuery = true)
  List<Habitacion> habitacionesMasConcurridasByFechaExacta(LocalDate fecha);

  @Query(value = """
          SELECT h.*, COUNT(c.id_cliente) AS nClientes
          FROM habitacion h
          LEFT JOIN cliente c ON h.id_habitacion = c.habitacion_id_habitacion
          WHERE DATE(c.fecha_ingreso) BETWEEN 'fecha_inicio' AND 'fecha_fin'
                OR DATE(c.fecha_salida) BETWEEN 'fecha_inicio' AND 'fecha_fin'
                OR ('fecha_inicio' BETWEEN DATE(c.fecha_ingreso) AND DATE(c.fecha_salida)
                    AND 'fecha_fin' BETWEEN DATE(c.fecha_ingreso) AND DATE(c.fecha_salida))
          GROUP BY h.id_habitacion
          ORDER BY nClientes DESC
             """, nativeQuery = true)
 List<Habitacion> habitacionesMasConcurridasByFechaInicioAndFechaFin(LocalDate fechaInicio, LocalDate fechaFin);
}
