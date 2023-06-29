package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Hotel;

import java.util.List;

public interface IHotelService {
  Hotel save(Hotel hotel);
  Hotel findById(Long id);
  List<Hotel> findAll();
}
