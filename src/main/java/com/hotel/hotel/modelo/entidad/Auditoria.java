package com.hotel.hotel.modelo.entidad;

import com.hotel.hotel.modelo.enums.Estado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class Auditoria {
  @Enumerated(EnumType.STRING)
  private Estado estado;

}
