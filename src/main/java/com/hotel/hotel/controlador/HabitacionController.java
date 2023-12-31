package com.hotel.hotel.controlador;

import com.hotel.hotel.commons.annotation.RedirigirEstadoHabitacion;
import com.hotel.hotel.modelo.entidad.Cliente;
import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.enums.EstadoCliente;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import com.hotel.hotel.modelo.servicio.interfaces.IClienteService;
import com.hotel.hotel.modelo.servicio.interfaces.IHabitacionService;
import com.hotel.hotel.modelo.servicio.interfaces.ITipoHabitacionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/habitacion")
public class HabitacionController {
  private final IHabitacionService habitacionService;
  private final ITipoHabitacionService tipoHabitacionService;
  private final IClienteService clienteService;

  @GetMapping("/lista")
  public String index(@RequestParam(value = "estado", required = false) EstadoHabitacion estadoHabitacion, Model model, HttpSession session){
    List<Habitacion> listaHabitaciones;
    Sort sort = Sort.by("estadoHabitacion", "tipoHabitacion.nombreTipoHabitacion", "nroHabitacion");
    if(estadoHabitacion != null){
      listaHabitaciones = habitacionService.findAllDistinctEliminadoAndEstadoHabitacion(estadoHabitacion, sort);
      session.setAttribute("estado", estadoHabitacion);
      EstadoHabitacion estado = (EstadoHabitacion) session.getAttribute("estado");
      log.info(estado.name());
    }else{
      listaHabitaciones = habitacionService.
              findAllDistinctEliminado(sort);
      session.removeAttribute("estado");
    }

    /*listaHabitaciones.forEach(h -> {
      h.setClientes(clienteService.findAllClientesHuespedesByIdHabitacion(h.getIdHabitacion()));
    });*/

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Lista de habitaciones");
    model.addAttribute("listaHabitaciones", listaHabitaciones);
    model.addAttribute("fragmento", "cartas");
    return "app/habitacion";
  }

  @GetMapping("/formulario-registrar")
  public String mostrarFormulario(@ModelAttribute Habitacion habitacion, Model model){
    model.addAttribute("template", "layout");
    model.addAttribute("title", "registro de habitacion");

    model.addAttribute("listaTiposHabitaciones", tipoHabitacionService.findAllDistinctEliminado(Sort.by("nombreTipoHabitacion")));
    model.addAttribute("habitacion", new Habitacion());
    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "registrar");
    return "app/habitacion";
  }

  @RedirigirEstadoHabitacion
  @PostMapping("/registrar")
  public String registrar(@ModelAttribute Habitacion habitacion, RedirectAttributes flash){
    habitacion.setEstado(Estado.ACTIVO);
    habitacion.setEstadoHabitacion(EstadoHabitacion.DISPONIBLE);
    habitacionService.save(habitacion);

    flash.addFlashAttribute("exito", "Habitación registrada correctamente!");
    return "redirect:/habitacion/lista";
  }

  @GetMapping("/formulario-modificar/{idHabitacion}")
  public String mostrarFormularioModificar(@PathVariable Long idHabitacion, Model model){
    Habitacion habitacion = habitacionService.findById(idHabitacion);

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Modificar habitación existente");

    model.addAttribute("listaTiposHabitaciones", tipoHabitacionService.findAllDistinctEliminado(Sort.by("nombreTipoHabitacion")));
    model.addAttribute("habitacion", habitacion);
    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "modificar");
    return "app/habitacion";
  }

  @RedirigirEstadoHabitacion
  @PostMapping("/modificar")
  public String modificar(@ModelAttribute Habitacion habitacion, RedirectAttributes flash){
    habitacionService.save(habitacion);
    flash.addFlashAttribute("exito", "Habitación modificada exitosamente");
    return "redirect:/habitacion/lista";
  }

  


  @RedirigirEstadoHabitacion
  @PostMapping("/eliminar")
  public String eliminar(@RequestParam Long idHabitacion, RedirectAttributes flash){
    Habitacion habitacion = habitacionService.findById(idHabitacion);
    habitacion.setEstado(Estado.ELIMINADO);
    habitacionService.save(habitacion);
    flash.addFlashAttribute("exito", "Habitación eliminada exitosamente");
    return "redirect:/habitacion/lista";
  }

  @RedirigirEstadoHabitacion
  @PostMapping("/poner-en-mantenimiento")
  public String ponerEnMantenimiento(@RequestParam Long idHabitacion, RedirectAttributes flash){
    Habitacion habitacion = habitacionService.findById(idHabitacion);
    habitacion.setEstadoHabitacion(EstadoHabitacion.EN_MANTENIMIENTO);
    habitacionService.save(habitacion);

    flash.addFlashAttribute("exito", "Habitación puesta en mantenimiento correctamente!");
    return "redirect:/habitacion/lista";
  }

  @RedirigirEstadoHabitacion
  @PostMapping("/habilitar")
  public String habilitar(@RequestParam Long idHabitacion, RedirectAttributes flash){
    Habitacion habitacion = habitacionService.findById(idHabitacion);
    habitacion.setEstadoHabitacion(EstadoHabitacion.DISPONIBLE);
    habitacionService.save(habitacion);

    flash.addFlashAttribute("exito", "Habitacion habilitada y disponible correctamente!");
    return "redirect:/habitacion/lista";
  }

  @RedirigirEstadoHabitacion
  @PostMapping("/desocupar-clientes")
  public String desocuparClientes(@RequestParam Long idHabitacion, @RequestParam List<Long> clientes, RedirectAttributes flash){
    List<Cliente> listaClientesHuespedes = clienteService.findAllClientesHuespedesByIdHabitacion(idHabitacion);
    listaClientesHuespedes.forEach(c ->{
      c.setEstadoCliente(EstadoCliente.DESOCUPADO);
      c.setFechaSalida(LocalDateTime.now());
      clienteService.save(c);
    });
    Habitacion habitacion = habitacionService.findById(idHabitacion);
    habitacion.setEstadoHabitacion(EstadoHabitacion.DISPONIBLE);
    habitacionService.save(habitacion);
    flash.addFlashAttribute("exito", "Clientes desocupados exitosamente, la habitación esta disponible");
    return "redirect:/habitacion/lista";
  }


  @ResponseBody
  @GetMapping("/mas-usados")
  public ResponseEntity<?> reporteHabitacionByFechas(@RequestParam int dia, @RequestParam int mes, @RequestParam int ano){
    LocalDate fechaExacta = LocalDate.of(ano, mes, dia);
    List<Habitacion> listaHabitaciones = habitacionService.habitacionesMasConcurridasByFechaExacta(fechaExacta);
    return ResponseEntity.ok().body(listaHabitaciones);
  }
}
