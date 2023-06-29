package com.hotel.hotel.modelo.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tipo_habitacion")
@Getter
@Setter
@NoArgsConstructor
public class TipoHabitacion extends Auditoria{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idTipoHabitacion;
  private String tipoHabitacion;
}
