package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IPersonaDao;
import com.hotel.hotel.modelo.entidad.Persona;
import com.hotel.hotel.modelo.servicio.interfaces.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements IPersonaService {
  private final IPersonaDao personaDao;

  @Override
  public Persona save(Persona persona) {
    return personaDao.save(persona);
  }

  @Override
  public Persona findById(Long id) {
    return personaDao.findById(id).orElse(null);
  }

  @Override
  public List<Persona> findAll(Sort sort) {
    return personaDao.findAll(sort);
  }

  @Override
  public Page<Persona> findAllDistinctEliminado(String query, Pageable pageable){
    return personaDao.findAllDistinctEliminado(query, pageable);
  }

  @Override
  public Persona findByDocumentoIdentidad(String documentoIdentidad){
    return personaDao.findByDocumentoIdentidad(documentoIdentidad);
  }

  @Override
  public List<Persona> findAllDistinctEliminado(Sort sort) {
    return personaDao.findAllDistinctEliminado(sort);
  }
}
