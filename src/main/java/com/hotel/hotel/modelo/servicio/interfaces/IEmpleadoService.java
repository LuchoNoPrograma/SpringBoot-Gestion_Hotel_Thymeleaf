package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Empleado;

import java.util.List;

public interface IEmpleadoService {
  Empleado saveWithPersona(Empleado empleado);
  Empleado save(Empleado empleado);
  Empleado findById(Long id);
  List<Empleado> findAll();
}
