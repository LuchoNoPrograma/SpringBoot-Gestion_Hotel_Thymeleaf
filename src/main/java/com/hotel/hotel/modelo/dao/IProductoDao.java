package com.hotel.hotel.modelo.dao;

import com.hotel.hotel.modelo.entidad.TipoProducto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Producto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoDao extends JpaRepository <Producto, Long> {
  @Query("SELECT p FROM Producto p WHERE p.nombreProducto LIKE '%?1%'")
  List<Producto> findAllLikeNombreProducto(String nombreProducto);

  @Query("SELECT p FROM Producto p WHERE p.estado != 'ELIMINADO' AND p.tipoProducto.idTipoProducto = ?1")
  List<Producto> findAllByTipoProducto(Long idTipoProducto, Sort sort);

  @Query("SELECT p FROM Producto p WHERE p.estado != 'ELIMINADO'")
  List<Producto> findAllDistinctEliminado(Sort sort);
}
