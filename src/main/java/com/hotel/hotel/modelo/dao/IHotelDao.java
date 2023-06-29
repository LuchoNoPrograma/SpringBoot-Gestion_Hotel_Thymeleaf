package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Hotel;

public interface IHotelDao extends JpaRepository <Hotel,Long>{
    
}
