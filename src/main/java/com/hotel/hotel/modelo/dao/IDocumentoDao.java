package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Documento;

public interface IDocumentoDao extends JpaRepository<Documento,Long> {
    
}
