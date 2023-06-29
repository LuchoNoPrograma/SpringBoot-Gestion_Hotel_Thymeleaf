package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.ITipoDocumentoDao;
import com.hotel.hotel.modelo.entidad.TipoDocumento;
import com.hotel.hotel.modelo.servicio.interfaces.ITipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {
  private final ITipoDocumentoDao tipoDocumentoDao;

  @Override
  public TipoDocumento save(TipoDocumento tipoDocumento) {
    return tipoDocumentoDao.save(tipoDocumento);
  }

  @Override
  public TipoDocumento findById(Long id) {
    return tipoDocumentoDao.findById(id).orElse(null);
  }
}
