package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Documento;

import java.util.List;

public interface IDocumentoService {
  Documento save(Documento documento);
  Documento findById(Long id);
  List<Documento> findAll();
}
