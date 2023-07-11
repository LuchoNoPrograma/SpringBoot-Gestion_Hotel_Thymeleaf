package com.hotel.hotel.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hotel.hotel.modelo.enums.Estado;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditoria {
  @Enumerated(EnumType.STRING)
  private Estado estado;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @CreatedDate
  private LocalDateTime fechaRegistro;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @LastModifiedDate
  private LocalDateTime fechaModificacion;
}
