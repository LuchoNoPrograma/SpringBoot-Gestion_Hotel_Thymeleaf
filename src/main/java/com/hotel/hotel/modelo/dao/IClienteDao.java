package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Cliente;

public interface IClienteDao extends JpaRepository <Cliente, Long> {
    
}
