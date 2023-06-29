package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IEmpleadoDao;
import com.hotel.hotel.modelo.dao.IPersonaDao;
import com.hotel.hotel.modelo.entidad.Empleado;
import com.hotel.hotel.modelo.servicio.interfaces.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements IEmpleadoService {
  private final IEmpleadoDao empleadoDao;
  private final IPersonaDao personaDao;

  @Transactional
  @Override
  public Empleado saveWithPersona(Empleado empleado) {
    personaDao.save(empleado.getPersona());
    return empleadoDao.save(empleado);
  }

  @Override
  public Empleado save(Empleado empleado) {
    return empleadoDao.save(empleado);
  }

  @Override
  public Empleado findById(Long id) {
    return empleadoDao.findById(id).orElse(null);
  }

  @Override
  public List<Empleado> findAll() {
    return empleadoDao.findAll();
  }
}
