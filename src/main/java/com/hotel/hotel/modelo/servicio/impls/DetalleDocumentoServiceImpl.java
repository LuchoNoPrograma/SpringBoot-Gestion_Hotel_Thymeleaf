package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IDetalleDocumentoDao;
import com.hotel.hotel.modelo.entidad.DetalleDocumento;
import com.hotel.hotel.modelo.servicio.interfaces.IDetalleDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleDocumentoServiceImpl implements IDetalleDocumentoService {
  private final IDetalleDocumentoDao detalleDocumentoDao;

  @Override
  public DetalleDocumento save(DetalleDocumento detalleDocumento) {
    return detalleDocumentoDao.save(detalleDocumento);
  }

  @Override
  public DetalleDocumento findById(Long id) {
    return detalleDocumentoDao.findById(id).orElse(null);
  }
}
