package com.hotel.hotel.modelo.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.TipoProducto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITipoProductoDao extends JpaRepository <TipoProducto, Long>{

  @Query("SELECT t FROM TipoProducto t WHERE t.estado != 'ELIMINADO'")
  List<TipoProducto> findAllDistinctEliminado(Sort sort);
}
