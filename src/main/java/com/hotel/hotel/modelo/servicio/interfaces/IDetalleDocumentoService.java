package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.DetalleDocumento;

public interface IDetalleDocumentoService {
  DetalleDocumento save(DetalleDocumento detalleDocumento);
  DetalleDocumento findById(Long id);
}
