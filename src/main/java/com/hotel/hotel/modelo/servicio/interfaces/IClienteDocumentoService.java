package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.ClienteDocumento;

public interface IClienteDocumentoService {
  ClienteDocumento save(ClienteDocumento clienteDocumento);
  ClienteDocumento findById(Long id);
}
