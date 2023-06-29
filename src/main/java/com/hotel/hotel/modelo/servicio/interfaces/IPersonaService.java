package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Persona;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IPersonaService {
  Persona save(Persona persona);
  Persona findById(Long id);
  List<Persona> findAll(Sort sort);
  Persona findByDocumentoIdentidad(String documentoIdentidad);
}
