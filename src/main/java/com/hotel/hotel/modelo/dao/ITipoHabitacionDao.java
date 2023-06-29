package com.hotel.hotel.modelo.dao;

import com.hotel.hotel.modelo.entidad.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoHabitacionDao extends JpaRepository<TipoHabitacion, Long> {
}
