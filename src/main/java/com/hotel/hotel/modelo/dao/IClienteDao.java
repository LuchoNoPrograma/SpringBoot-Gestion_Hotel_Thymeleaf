package com.hotel.hotel.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.modelo.entidad.Cliente;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IClienteDao extends JpaRepository <Cliente, Long> {

  @Query("""
          SELECT c FROM Cliente c
          INNER JOIN FETCH c.persona p
          INNER JOIN FETCH c.habitacion h
          ORDER BY c.fechaRegistro
          """)
  List<Cliente> findAllEagerly();

  @Query("""
          SELECT c FROM Cliente c
            INNER JOIN FETCH c.persona p
            INNER JOIN FETCH c.habitacion h
            WHERE c.idCliente = ?1
          """)
  Optional<Cliente> findByIdEagerly(Long idCliente);

  @Query("""
          SELECT c FROM Cliente c
          INNER JOIN FETCH c.persona p
          INNER JOIN FETCH c.habitacion h
          INNER JOIN FETCH c.clientesBeneficiados cb
          WHERE c.clienteTitular.idCliente = c.idCliente
          ORDER BY c.fechaRegistro""")
  List<Cliente> findAllClientesTitularesOcupandoHabitacion();

  @Query("""
          SELECT c FROM Cliente c
          INNER JOIN FETCH c.persona p
          WHERE c.habitacion.idHabitacion = ?1
          AND c.clienteTitular = ?2
          ORDER BY c.fechaRegistro
          """)
  List<Cliente> findAllByIdHabitacionAndIdClienteTitular(Long idHabitacion, Long idCliente);

  @Query("""
    SELECT c FROM Cliente c
    INNER JOIN FETCH c.persona p
    WHERE c.habitacion.idHabitacion = ?1
    AND c.fechaRegistro <= CURRENT_TIMESTAMP 
    AND (c.fechaSalida IS NULL OR c.fechaSalida >= CURRENT_TIMESTAMP )
""")
  List<Cliente> findAllOcupandoHabitacionActualmenteByIdHabitacion(Long idHabitacion);
}
