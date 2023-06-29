package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Producto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoDao extends JpaRepository <Producto, Long> {
  @Query("SELECT p FROM Producto p WHERE p.nombreProducto LIKE '%?1%'")
  List<Producto> findAllLikeNombreProducto(String nombreProducto);
}
