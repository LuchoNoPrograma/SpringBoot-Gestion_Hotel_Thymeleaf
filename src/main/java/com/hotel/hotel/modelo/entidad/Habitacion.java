package com.hotel.hotel.modelo.entidad;
import javax.persistence.*;

import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Table(name = "habitacion")
@Getter
@Setter
@NoArgsConstructor
public class Habitacion extends Auditoria{
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id_hotel")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_habitacion_id_tipo_habitacion")
    private TipoHabitacion tipoHabitacion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "habitacion")
    private List<Cliente> clientes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;
    private Integer nroHabitacion;
    private Byte capacidadHabitacion;
    private Float precioHabitacion;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoHabitacion estadoHabitacion;
}
