package com.hotel.hotel.modelo.entidad;
import java.time.LocalDateTime;
import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCliente")
public class Cliente extends Auditoria{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id_persona")
    private Persona persona;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_titular_id_cliente")
    private Cliente clienteTitular;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clienteTitular")
    private List<Cliente> clientesBeneficiados;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<ClienteDocumento> clienteDocumentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habitacion_id_habitacion")
    private Habitacion habitacion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaRegistro;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaIngreso;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaSalida;
}
