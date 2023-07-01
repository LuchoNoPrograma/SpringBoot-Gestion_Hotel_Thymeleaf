package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Cliente;
import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.entidad.Persona;
import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.enums.EstadoCivil;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import com.hotel.hotel.modelo.enums.Sexo;
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
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {
  private final IClienteService clienteService;
  private final IHabitacionService habitacionService;
  private final IPersonaService personaService;

  @GetMapping("/lista/titulares")
  public String index(Model model) {
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Lista de clientes");
    model.addAttribute("listaClientes", clienteService.findAllClientesTitularesOcupandoHabitacion());
    model.addAttribute("fragmento", "tabla");

    return "app/cliente";
  }

  @GetMapping("/formulario-registrar")
  public String formularioRegistro(@RequestParam("titular") boolean tipo,@RequestParam("nro") String documentoIdentidad,
                                   @ModelAttribute Cliente cliente, Model model) {

    Persona persona = personaService.findByDocumentoIdentidad(documentoIdentidad);
    persona.setDocumentoIdentidad(documentoIdentidad);
    cliente.setPersona(persona);

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Registrar nuevo cliente");
    model.addAttribute("listaEstadosCiviles", EstadoCivil.values());
    model.addAttribute("listaHabitacionesDisponibles", habitacionService.findAllByEstadoHabitacion(EstadoHabitacion.DISPONIBLE));
    model.addAttribute("listaSexos", Sexo.values());
    model.addAttribute("cliente", cliente);
    model.addAttribute("titular", tipo);

    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "registrar");
    return "app/cliente";
  }

  @GetMapping("/registrar")
  public String registrar(@ModelAttribute Cliente cliente, RedirectAttributes flash) {
    cliente.getHabitacion().setEstadoHabitacion(EstadoHabitacion.OCUPADO);
    clienteService.saveWithPersonaAndHabitacion(cliente);
    flash.addFlashAttribute("exito", "Cliente registrado exitosamente");
    return "redirect:/cliente/inicio";
  }

  @GetMapping("/titular/{idClienteTitular}/habitacion/{idHabitacion}")
  public String clientesPorHabitacion(Model model, @PathVariable Long idHabitacion, @PathVariable Long idClienteTitular) {
    Habitacion habitacion = habitacionService.findById(idHabitacion);

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Clientes en habitacion: " + habitacion.getNroHabitacion());
    model.addAttribute("listaClientes", clienteService.findAllByIdHabitacionAndIdClienteTitular(idHabitacion, idClienteTitular));
    model.addAttribute("fragmento", "tabla");

    return "app/cliente";
  }

  @GetMapping("/habitacion/{idHabitacion}/actual")
  public String clientesEnHabitacionOcupandoActualmente(Model model, @PathVariable Long idHabitacion) {
    Habitacion habitacion = habitacionService.findById(idHabitacion);

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Clientes en habitacion: " + habitacion.getNroHabitacion());
    model.addAttribute("listaClientes", clienteService.findAllOcupandoHabitacionActualmenteByIdHabitacion(idHabitacion));
    model.addAttribute("fragmento", "tabla");

    return "app/cliente";
  }

  @GetMapping("/calendario")
  public String reservas(Model model) {
    model.addAttribute("template", "layouts-icon-sidebar");
    model.addAttribute("title", "Administrar clientes");
    Sort orden = Sort.by("fechaRegistro").ascending();
    model.addAttribute("listaClientes", clienteService.findAll(orden));
    model.addAttribute("listaHabitacionesDisponibles", habitacionService.findAllByEstadoHabitacion(EstadoHabitacion.DISPONIBLE));

    model.addAttribute("fragmento", "calendario");
    return "app/cliente-reserva";
  }

  @Transactional
  @GetMapping("/api/lista")
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

  @ResponseBody
  @GetMapping("/api/buscar/{idCliente}")
  public ResponseEntity<?> buscarClienteRest(@PathVariable Long idCliente) {
    try {
      Cliente cliente = clienteService.findByIdEagerly(idCliente);

      return ResponseEntity.ok().body(cliente);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e);
    }
  }
}
