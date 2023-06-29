package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Cliente;

import java.util.List;

public interface IClienteService {
  Cliente save(Cliente cliente);
  Cliente findById(Long id);
  List<Cliente> findAll();
}
