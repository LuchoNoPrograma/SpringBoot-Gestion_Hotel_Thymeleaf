package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Empleado;

public interface IEmpleadoDao extends JpaRepository <Empleado, Long> {
    
}
