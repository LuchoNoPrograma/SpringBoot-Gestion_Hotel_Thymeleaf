package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.TipoDocumento;

public interface ITipoDocumentoService {
  TipoDocumento save(TipoDocumento tipoDocumento);
  TipoDocumento findById(Long id);
}
