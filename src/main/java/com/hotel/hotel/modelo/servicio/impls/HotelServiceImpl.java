package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IHotelDao;
import com.hotel.hotel.modelo.entidad.Hotel;
import com.hotel.hotel.modelo.servicio.interfaces.IHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements IHotelService {
  private final IHotelDao hotelDao;

  @Override
  public Hotel save(Hotel hotel) {
    return hotelDao.save(hotel);
  }

  @Override
  public Hotel findById(Long id) {
    return hotelDao.findById(id).orElse(null);
  }

  @Override
  public List<Hotel> findAll() {
    return hotelDao.findAll();
  }
}
