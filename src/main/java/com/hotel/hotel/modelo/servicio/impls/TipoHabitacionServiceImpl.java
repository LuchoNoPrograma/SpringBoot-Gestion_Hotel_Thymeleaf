package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.ITipoHabitacionDao;
import com.hotel.hotel.modelo.entidad.TipoHabitacion;
import com.hotel.hotel.modelo.servicio.interfaces.ITipoHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoHabitacionServiceImpl implements ITipoHabitacionService {
  private final ITipoHabitacionDao tipoHabitacionDao;
  @Override
  public TipoHabitacion save(TipoHabitacion tipoHabitacion) {
    return tipoHabitacionDao.save(tipoHabitacion);
  }

  @Override
  public TipoHabitacion findById(Long id) {
    return tipoHabitacionDao.findById(id).orElse(null);
  }

  @Override
  public List<TipoHabitacion> findAll() {
    return tipoHabitacionDao.findAll();
  }

  @Override
  public List<TipoHabitacion> findAllDistinctEliminado(Sort sort) {
    return tipoHabitacionDao.findAllDistinctEliminado(sort);
  }
}
