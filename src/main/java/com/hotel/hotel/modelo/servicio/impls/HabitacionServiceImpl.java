package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IHabitacionDao;
import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import com.hotel.hotel.modelo.servicio.interfaces.IHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl implements IHabitacionService {
  private final IHabitacionDao habitacionDao;

  @Override
  public Habitacion save(Habitacion habitacion) {
    return habitacionDao.save(habitacion);
  }

  @Override
  public Habitacion findById(Long id) {
    return habitacionDao.findById(id).orElse(null);
  }

  @Override
  public List<Habitacion> findAllDistinctEliminado(Sort sort) {
    return habitacionDao.findAllDistinctEliminado(sort);
  }

  @Override
  public List<Habitacion> findAllDistinctEliminadoAndEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
    return habitacionDao.findAllDistinctEliminadoByEstadoHabitacion(estadoHabitacion);
  }
}
