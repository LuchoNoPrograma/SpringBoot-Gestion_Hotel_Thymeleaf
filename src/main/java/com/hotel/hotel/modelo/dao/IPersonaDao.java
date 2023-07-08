package com.hotel.hotel.modelo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Persona;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long> {
  @Query("SELECT p FROM Persona p WHERE p.documentoIdentidad = ?1")
  Persona findByDocumentoIdentidad(String documentoIdentidad);

  @Query("""
        SELECT p FROM Persona AS p 
        WHERE p.estado != 'ELIMINADO'
        AND UPPER(p.nombre) LIKE %?1%
        OR UPPER(p.apellido) LIKE %?1%
        OR p.documentoIdentidad LIKE %?1%
  """)
  Page<Persona> findAllDistinctEliminado(String query, Pageable pageable);


  @Query
  List<Persona> findAllDistinctEliminado(Sort sort);
}
