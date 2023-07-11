package com.hotel.hotel.modelo.dao;

import com.hotel.hotel.modelo.entidad.TipoHabitacion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITipoHabitacionDao extends JpaRepository<TipoHabitacion, Long> {
  @Query("SELECT t FROM TipoHabitacion t WHERE t.estado != 'ELIMINADO'")
  List<TipoHabitacion> findAllDistinctEliminado(Sort sort);
}
