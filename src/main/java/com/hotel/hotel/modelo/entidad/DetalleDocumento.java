package com.hotel.hotel.modelo.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "detalle_documento")
@Getter
@Setter
@NoArgsConstructor
public class DetalleDocumento extends Auditoria {
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "documento_id_documento")
  private Documento documento;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "habitacion_id_habitacion")
  private Habitacion habitacion;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "producto_id_producto")
  private Producto producto;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idDetalleDocumento;
  private String detalle;
  private Integer cantidad;
  private LocalDateTime fechaLlegada;
  private LocalDateTime fechaSalida;
}
