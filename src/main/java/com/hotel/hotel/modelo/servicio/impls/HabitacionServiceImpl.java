package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IHabitacionDao;
import com.hotel.hotel.modelo.entidad.Habitacion;
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
  public List<Habitacion> findAll(Sort sort) {
    return habitacionDao.findAll(sort);
  }

  @Override
 public List<Habitacion> findAllByEstadoHabitacion(String estadoHabitacion) {
    return findAllByEstadoHabitacion(estadoHabitacion);
  }
}
