package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Producto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProductoService {
  Producto save(Producto producto);
  List<Producto> findAll(Sort sort);
  Producto findById(Long id);
  List<Producto> findAllLikeNombreProducto(String nombreProducto);

  List<Producto> findAllByTipoProducto(Long idTipoProducto, Sort sort);

  List<Producto> findAllDistinctEliminado(Sort sort);
}
