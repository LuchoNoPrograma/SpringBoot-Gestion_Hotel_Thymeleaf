package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.ClienteDocumento;

public interface IClienteDocumentoDao extends JpaRepository<ClienteDocumento, Long> {
    
}
