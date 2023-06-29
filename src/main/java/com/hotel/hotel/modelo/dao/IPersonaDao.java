package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Persona;
import org.springframework.data.jpa.repository.Query;

public interface IPersonaDao extends JpaRepository<Persona, Long> {
  @Query("SELECT p FROM Persona p WHERE p.documentoIdentidad = ?1")
  Persona findByDocumentoIdentidad(String documentoIdentidad);
}
