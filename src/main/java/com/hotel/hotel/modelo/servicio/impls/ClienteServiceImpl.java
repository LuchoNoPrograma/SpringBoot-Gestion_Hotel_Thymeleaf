package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IClienteDao;
import com.hotel.hotel.modelo.entidad.Cliente;
import com.hotel.hotel.modelo.servicio.interfaces.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {
  private final IClienteDao clienteDao;

  @Override
  public Cliente save(Cliente cliente) {
    return clienteDao.save(cliente);
  }

  @Override
  public Cliente findById(Long id) {
    return clienteDao.findById(id).orElse(null);
  }


  @Override
  public List<Cliente> findAll() {
    return clienteDao.findAll();
  }
}
