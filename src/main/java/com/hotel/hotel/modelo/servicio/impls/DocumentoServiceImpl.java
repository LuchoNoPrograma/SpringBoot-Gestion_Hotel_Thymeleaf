package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IDocumentoDao;
import com.hotel.hotel.modelo.entidad.Documento;
import com.hotel.hotel.modelo.servicio.interfaces.IDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentoServiceImpl implements IDocumentoService {
  private final IDocumentoDao documentoDao;

  @Override
  public Documento save(Documento documento) {
    return documentoDao.save(documento);
  }

  @Override
  public Documento findById(Long id) {
    return documentoDao.findById(id).orElse(null);
  }

  @Override
  public List<Documento> findAll() {
    return documentoDao.findAll();
  }
}
