package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IProductoDao;
import com.hotel.hotel.modelo.entidad.Producto;
import com.hotel.hotel.modelo.servicio.interfaces.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {
  private final IProductoDao productoDao;

  @Override
  public Producto save(Producto producto) {
    return productoDao.save(producto);
  }

  @Override
  public List<Producto> findAll(Sort sort) {
    return productoDao.findAll(sort);
  }

  @Override
  public Producto findById(Long id) {
    return productoDao.findById(id).orElse(null);
  }

  @Override
  public List<Producto> findAllLikeNombreProducto(String nombreProducto) {
    return productoDao.findAllLikeNombreProducto(nombreProducto);
  }

  @Override
  public List<Producto> findAllByTipoProducto(Long idTipoProducto, Sort sort) {
    return productoDao.findAllByTipoProducto(idTipoProducto, sort);
  }

  @Override
  public List<Producto> findAllDistinctEliminado(Sort sort) {
    return productoDao.findAllDistinctEliminado(sort);
  }
}
