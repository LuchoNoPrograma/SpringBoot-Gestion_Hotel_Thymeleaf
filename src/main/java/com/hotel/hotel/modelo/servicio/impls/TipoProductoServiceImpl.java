package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.ITipoProductoDao;
import com.hotel.hotel.modelo.entidad.TipoProducto;
import com.hotel.hotel.modelo.servicio.interfaces.ITipoProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoProductoServiceImpl implements ITipoProductoService {
  private final ITipoProductoDao tipoProductoDao;

  @Override
  public TipoProducto save(TipoProducto tipoProducto) {
    return tipoProductoDao.save(tipoProducto);
  }

  @Override
  public TipoProducto findById(Long id) {
    return tipoProductoDao.findById(id).orElse(null);
  }

  @Override
  public List<TipoProducto> findAllDistinctEliminado(Sort sort){
    return tipoProductoDao.findAllDistinctEliminado(sort);
  }
}
