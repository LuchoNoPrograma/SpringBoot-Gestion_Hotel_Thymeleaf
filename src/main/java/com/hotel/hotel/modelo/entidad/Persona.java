package com.hotel.hotel.modelo.entidad;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hotel.hotel.modelo.enums.EstadoCivil;
import com.hotel.hotel.modelo.enums.Sexo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor
public class Persona extends Auditoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String documentoIdentidad;
    private String nacionalidad;
    private String procedencia;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    private String profesion;
    private String celular;

    @Transient
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String nombreCompleto;

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
