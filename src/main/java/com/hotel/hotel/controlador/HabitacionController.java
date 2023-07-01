package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import com.hotel.hotel.modelo.servicio.interfaces.IHabitacionService;
import com.hotel.hotel.modelo.servicio.interfaces.ITipoHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/habitacion")
public class HabitacionController {
  private final IHabitacionService habitacionService;
  private final ITipoHabitacionService tipoHabitacionService;

  @GetMapping("/lista")
  public String index(@RequestParam(value = "estado", required = false) EstadoHabitacion estadoHabitacion,Model model){
    List<Habitacion> listaHabitaciones;
    if(estadoHabitacion != null){
      listaHabitaciones = habitacionService.findAllByEstadoHabitacion(estadoHabitacion);
    }else{
      listaHabitaciones = habitacionService.findAll(Sort.by("nroHabitacion"));
    }

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Lista de empleados");
    model.addAttribute("listaHabitaciones", listaHabitaciones);
    model.addAttribute("fragmento", "cartas");
    return "app/habitacion";
  }

  @GetMapping("/formulario-registrar")
  public String mostrarFormulario(@ModelAttribute Habitacion habitacion, Model model){
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Lista de empleados");

    model.addAttribute("listaTiposHabitaciones", tipoHabitacionService.findAll());
    model.addAttribute("habitacion", new Habitacion());
    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "registrar");
    return "app/habitacion";
  }

  @PostMapping("/registrar")
  public String registrar(@ModelAttribute Habitacion habitacion, RedirectAttributes flash){
    habitacion.setEstado(Estado.ACTIVO);
    habitacion.setEstadoHabitacion(EstadoHabitacion.DISPONIBLE);
    habitacionService.save(habitacion);

    flash.addFlashAttribute("exito", "Habitación registrada correctamente");
    return "redirect:/habitacion/inicio";
  }
}
