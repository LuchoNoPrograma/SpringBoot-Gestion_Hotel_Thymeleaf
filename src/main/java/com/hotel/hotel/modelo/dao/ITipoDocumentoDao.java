package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.TipoDocumento;

public interface ITipoDocumentoDao extends JpaRepository <TipoDocumento, Long>{
    
}
