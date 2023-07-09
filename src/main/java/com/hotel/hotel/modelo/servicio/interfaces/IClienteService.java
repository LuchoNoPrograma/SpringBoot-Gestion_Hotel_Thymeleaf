package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.entidad.Cliente;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClienteService {
  Cliente save(Cliente cliente);

  @Transactional
  Cliente saveWithPersonaAndHabitacion(Cliente cliente);

  Cliente findById(Long id);
  List<Cliente> findAll(Sort sort);

  List<Cliente> findAllEagerly();

  Cliente findByIdEagerly(Long id);

  List<Cliente> findAllClientesTitularesOcupandoHabitacion();

  List<Cliente> findAllByIdHabitacionAndIdClienteTitular(Long idHabitacion, Long idCliente);

  List<Cliente> findAllOcupandoHabitacionActualmenteByIdHabitacion(Long idHabitacion);

  List<Cliente> findAllClientesHuespedesByIdHabitacion(Long idHabitacion);
}
