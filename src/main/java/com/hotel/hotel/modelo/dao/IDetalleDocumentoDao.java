package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.DetalleDocumento;

public interface IDetalleDocumentoDao extends JpaRepository <DetalleDocumento, Long> {
    
}
