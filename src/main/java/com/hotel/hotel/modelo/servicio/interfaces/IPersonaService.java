package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IPersonaService {
  Persona save(Persona persona);
  Persona findById(Long id);
  List<Persona> findAll(Sort sort);
  Page<Persona> findAllDistinctEliminado(String string, Pageable pageable);
  Persona findByDocumentoIdentidad(String documentoIdentidad);
  List<Persona> findAllDistinctEliminado(Sort sort);
}
