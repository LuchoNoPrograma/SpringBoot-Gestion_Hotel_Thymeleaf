package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.modelo.dao.IClienteDao;
import com.hotel.hotel.modelo.dao.IHabitacionDao;
import com.hotel.hotel.modelo.dao.IPersonaDao;
import com.hotel.hotel.modelo.entidad.Cliente;
import com.hotel.hotel.modelo.servicio.interfaces.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {
  private final IClienteDao clienteDao;
  private final IPersonaDao personaDao;
  private final IHabitacionDao habitacionDao;

  @Override
  public Cliente save(Cliente cliente) {
    return clienteDao.save(cliente);
  }

  @Transactional
  @Override
  public Cliente saveWithPersonaAndHabitacion(Cliente cliente){
    habitacionDao.save(cliente.getHabitacion());
    personaDao.save(cliente.getPersona());
    return clienteDao.save(cliente);
  }

  @Override
  public Cliente findById(Long id) {
    return clienteDao.findById(id).orElse(null);
  }


  @Override
  public List<Cliente> findAll(Sort sort) {
    return clienteDao.findAll(sort);
  }

  @Override
  public List<Cliente> findAllEagerly(){
    return clienteDao.findAllEagerly();
  }

  @Override
  public Cliente findByIdEagerly(Long id){
    return clienteDao.findByIdEagerly(id).orElse(null);
  }

  @Override
  public List<Cliente> findAllClientesTitularesOcupandoHabitacion(){
    return clienteDao.findAllClientesTitularesOcupandoHabitacion();
  }

  @Override
  public List<Cliente> findAllByIdHabitacionAndIdClienteTitular(Long idHabitacion, Long idCliente){
    return clienteDao.findAllByIdHabitacionAndIdClienteTitular(idHabitacion, idCliente);
  }

  @Override
  public List<Cliente> findAllOcupandoHabitacionActualmenteByIdHabitacion(Long idHabitacion){
    return clienteDao.findAllOcupandoHabitacionActualmenteByIdHabitacion(idHabitacion);
  }

  @Override
  public List<Cliente> findAllClientesHuespedesByIdHabitacion(Long idHabitacion){
    return clienteDao.findAllClientesHuespedesByIdHabitacion(idHabitacion);
  }
}
