package com.hotel.hotel.modelo.entidad;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "documento")
@Getter
@Setter
@NoArgsConstructor
public class Documento extends Auditoria{
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documento")
    private List<DetalleDocumento> detallesDocumentos;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documento")
    private List<ClienteDocumento> clientesDocumentos;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_documento_id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;
    private String nit;
    private String codigoFactura;
    private LocalDateTime fechaEmision;
    private Float precioTotal;
    private Float descuento;
    private String concepto;
}
