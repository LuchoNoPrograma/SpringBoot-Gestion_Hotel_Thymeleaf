package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Cliente;
import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.entidad.Persona;
import com.hotel.hotel.modelo.enums.*;
import com.hotel.hotel.modelo.servicio.interfaces.IClienteService;
import com.hotel.hotel.modelo.servicio.interfaces.IHabitacionService;
import com.hotel.hotel.modelo.servicio.interfaces.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

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
  public String formularioRegistro(@RequestParam("titular") boolean tipo, @RequestParam("nro") String documentoIdentidad,
                                   @RequestParam("id") Long idHabitacion,
                                   @ModelAttribute Cliente cliente, Model model) {
    //True para titular, false para beneficiario
    Persona persona = personaService.findByDocumentoIdentidad(documentoIdentidad);
    if (persona == null) {
      persona = new Persona();
    }

    persona.setDocumentoIdentidad(documentoIdentidad);
    cliente.setPersona(persona);
    cliente.setHabitacion(habitacionService.findById(idHabitacion));

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Registrar nuevo cliente");
    model.addAttribute("listaEstadosCiviles", EstadoCivil.values());
    model.addAttribute("listaSexos", Sexo.values());
    model.addAttribute("cliente", cliente);
    model.addAttribute("titular", tipo);
    if (!tipo) {
      model.addAttribute("listaTitulares", clienteService.findAllClientesTitularesOcupandoHabitacion());
    }

    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "registrar");
    return "app/cliente";
  }

  @GetMapping("/habitacion/{idHabitacion}/actual")
  public String clientesEnHabitacionOcupandoActualmente(Model model, @PathVariable Long idHabitacion) {
    Habitacion habitacion = habitacionService.findById(idHabitacion);

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Clientes en habitacion: " + habitacion.getNroHabitacion());
    model.addAttribute("listaClientes", clienteService.findAllOcupandoHabitacionActualmenteByIdHabitacion(idHabitacion));
    model.addAttribute("habitacion", habitacion);
    model.addAttribute("fragmento", "tabla");

    return "app/cliente";
  }

  @PostMapping("/registrar")
  public String registrar(@RequestParam boolean titular, @RequestParam(value = "id-titular", required = false) Long idTitular,
                          @ModelAttribute Cliente cliente, RedirectAttributes flash) {
    Habitacion habitacion = habitacionService.findById(cliente.getHabitacion().getIdHabitacion());
    habitacion.setEstadoHabitacion(EstadoHabitacion.OCUPADO);
    cliente.setHabitacion(habitacion);
    cliente.setEstadoCliente(EstadoCliente.HUESPED);
    cliente.setEstado(Estado.ACTIVO);

    Cliente persistido = clienteService.saveWithPersonaAndHabitacion(cliente);
    //Si es titular, relacionarse con si mismo
    //Caso contrario con su titular
    if (titular) {
      persistido.setClienteTitular(persistido);
    } else {
      persistido.setClienteTitular(clienteService.findById(idTitular));
    }

    cliente.setFechaRegistro(LocalDateTime.now());
    clienteService.save(cliente);
    flash.addFlashAttribute("exito", "Cliente registrado exitosamente");
    return "redirect:/cliente/habitacion/" + persistido.getHabitacion().getIdHabitacion() + "/actual";
  }


  @GetMapping("/formulario-modificar/{idCliente}")
  public String formularioModificar(@PathVariable Long idCliente, Model model) {
    Cliente cliente = clienteService.findByIdEagerly(idCliente);

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Modificar cliente existente");
    model.addAttribute("listaEstadosCiviles", EstadoCivil.values());
    model.addAttribute("listaSexos", Sexo.values());
    model.addAttribute("cliente", cliente);
    model.addAttribute("titular", false);

    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "modificar");
    return "app/cliente";
  }



  @PostMapping("/modificar")
  public String registrar(@ModelAttribute Cliente cliente, RedirectAttributes flash) {
    Habitacion habitacion = habitacionService.findById(cliente.getHabitacion().getIdHabitacion());
    cliente.setEstado(Estado.ACTIVO);
    cliente.getPersona().setEstado(Estado.ACTIVO);

    cliente.setHabitacion(habitacion);
    Cliente persistido = clienteService.saveWithPersonaAndHabitacion(cliente);

    clienteService.save(cliente);
    flash.addFlashAttribute("exito", "Cliente modificado exitosamente");
    return "redirect:/cliente/habitacion/" + persistido.getHabitacion().getIdHabitacion() + "/actual";
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

  @Transactional
  @GetMapping("/api/lista")
  @ResponseBody
  public ResponseEntity<?> listaClientesRest() {
    Sort orden = Sort.by("fechaRegistro").ascending();
    return ResponseEntity.ok().body(clienteService.findAllEagerly());
  }
}
