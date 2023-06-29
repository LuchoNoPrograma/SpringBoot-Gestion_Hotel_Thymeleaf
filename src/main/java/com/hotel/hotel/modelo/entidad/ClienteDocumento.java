package com.hotel.hotel.modelo.entidad;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente_documento")
@Getter
@Setter
@NoArgsConstructor
public class ClienteDocumento extends Auditoria{
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id_cliente")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id_documento")
    private Documento documento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClienteDocumento;
}
