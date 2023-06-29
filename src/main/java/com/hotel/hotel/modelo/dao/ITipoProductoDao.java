package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.TipoProducto;

public interface ITipoProductoDao extends JpaRepository <TipoProducto, Long>{
    
}
