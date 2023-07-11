package com.hotel.hotel.controlador;

import com.hotel.hotel.commons.annotation.RedirigirEstadoHabitacion;
import com.hotel.hotel.modelo.entidad.Cliente;
import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.entidad.Persona;
import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import com.hotel.hotel.modelo.servicio.interfaces.IClienteService;
import com.hotel.hotel.modelo.servicio.interfaces.IHabitacionService;
import com.hotel.hotel.modelo.servicio.interfaces.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ClienteReservaController {
  private final IClienteService clienteService;
  private final IHabitacionService habitacionService;
  private final IPersonaService personaService;


  //Reservas y actividades
  @GetMapping("/calendario")
  public String reservas(@RequestParam(value = "id", required = false) Long idHabitacion, Model model) {
    if(idHabitacion != null){
      Habitacion habitacion = habitacionService.findById(idHabitacion);
    }


    model.addAttribute("template", "layouts-icon-sidebar");
    model.addAttribute("title", "Administrar clientes");
    Sort orden = Sort.by("fechaRegistro").ascending();

//<<<<<<< HEAD
  //  model.addAttribute("listaPersonas", personaService.findAllDistinctEliminado(null, null));

    model.addAttribute("listaPersonas", personaService.findAllDistinctEliminado(Sort.by("nombre"))  );
    model.addAttribute("listaClientes", clienteService.findAll(orden));

//    model.addAttribute("listaHabitacionesDisponibles", habitacionService.findAllDistinctEliminadoAndEstadoHabitacion(EstadoHabitacion.DISPONIBLE));

    model.addAttribute("fragmento", "calendario");
    return "app/cliente-reserva";
  }


  @GetMapping("/agregar-reserva")
  public String formularioReserva(@ModelAttribute Cliente cliente, Model model) {
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Registrar nuevo empleado");
    model.addAttribute("fragmento", "formulario-reserva");

    return "app/cliente-reserva";
  }

  @GetMapping("/confirmar-reserva")
  public String confirmarReserva(@RequestParam Long idHabitacion, RedirectAttributes flash) {


    return "redirect:/reserva/calendario";
  }

  @PostMapping("/registrar-reserva")
  public String registrarReserva(@ModelAttribute Cliente cliente, RedirectAttributes flash) {
    return "app/cliente";
  }


  @Transactional
  @GetMapping("/api/lista")
  @ResponseBody
  public ResponseEntity<?> listaClientesRest() {
    Sort orden = Sort.by("fechaRegistro").ascending();


    return ResponseEntity.ok().body(clienteService.findAllEagerly());
  }

  @ResponseBody
  @PostMapping("/api/registrar")
  public ResponseEntity<?> registrarClienteRest(@RequestBody Cliente cliente) {
    try {
      Habitacion habitacion = habitacionService.findById(cliente.getHabitacion().getIdHabitacion());
      habitacion.setEstadoHabitacion(cliente.getHabitacion().getEstadoHabitacion());

      Persona persona = personaService.findByDocumentoIdentidad(cliente.getPersona().getDocumentoIdentidad());

      if (persona != null) {
        persona.setNombre(cliente.getPersona().getNombre());
        persona.setApellido(cliente.getPersona().getApellido());
        persona.setDocumentoIdentidad(cliente.getPersona().getDocumentoIdentidad());
        cliente.setPersona(persona);
      } else {
        cliente.getPersona().setEstado(Estado.ACTIVO);
      }

      cliente.setEstado(Estado.ACTIVO);
      cliente.setHabitacion(habitacion);
      Cliente persistido = clienteService.saveWithPersonaAndHabitacion(cliente);

      Cliente retornado = clienteService.findByIdEagerly(persistido.getIdCliente());
      return ResponseEntity.ok().body(retornado);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().body(e);
    }
  }


}
