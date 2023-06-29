package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IClienteDocumentoDao;
import com.hotel.hotel.modelo.entidad.ClienteDocumento;
import com.hotel.hotel.modelo.servicio.interfaces.IClienteDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteDocumentoServiceImpl implements IClienteDocumentoService {
  private final IClienteDocumentoDao clienteDocumentoDao;

  @Override
  public ClienteDocumento save(ClienteDocumento clienteDocumento) {
    return clienteDocumentoDao.save(clienteDocumento);
  }

  @Override
  public ClienteDocumento findById(Long id) {
    return clienteDocumentoDao.findById(id).orElse(null);
  }
}
