package com.hotel.hotel.modelo.servicio.interfaces;


import com.hotel.hotel.modelo.entidad.TipoProducto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ITipoProductoService {
  TipoProducto save(TipoProducto tipoProducto);
  TipoProducto findById(Long id);

  List<TipoProducto> findAllDistinctEliminado(Sort sort);
}
