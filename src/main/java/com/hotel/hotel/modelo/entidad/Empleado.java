package com.hotel.hotel.modelo.entidad;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.hotel.hotel.modelo.enums.Cargo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@NoArgsConstructor
public class Empleado extends Auditoria{
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id_hotel")
    private Hotel hotel;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;


    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    private Double sueldo;
    private Integer horasTrabajo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaContrato;
}
