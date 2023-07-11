package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.TipoHabitacion;
import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.servicio.interfaces.ITipoHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tipo-habitacion")
public class TipoHabitacionController {
  private final ITipoHabitacionService tipoHabitacionService;

  @GetMapping("/lista")
  public String lista(Model model){
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Lista de tipos de habitaciones");
    model.addAttribute("fragmento", "tabla");
    Sort orden = Sort.by("nombreTipoHabitacion");
    model.addAttribute("listaTiposHabitaciones", tipoHabitacionService.findAllDistinctEliminado(orden));

    return "app/tipo-habitacion";
  }

  @GetMapping("/formulario-registro")
  public String mostrarFormularioRegistro(@ModelAttribute TipoHabitacion tipoHabitacion, Model model){
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Registrar nuevo tipo de habitación");
    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "registrar");
    model.addAttribute("tipoHabitacion", tipoHabitacion);
    return "app/tipo-habitacion";
  }

  @GetMapping("/formulario-modificar/{idTipoHabitacion}")
  public String modificar(@PathVariable Long idTipoHabitacion , Model model){

    TipoHabitacion tipoHabitacion =  tipoHabitacionService.findById(idTipoHabitacion);
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Modificar Tipo producto Existente");
    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "modificar");
    model.addAttribute("tipoHabitacion", tipoHabitacion);
    return "app/tipo-habitacion";
  }

  @PostMapping("/eliminar")
  public String eliminar(@RequestParam Long idTipoHabitacion, RedirectAttributes flash){
    TipoHabitacion tipoHabitacion = tipoHabitacionService.findById(idTipoHabitacion);
    tipoHabitacion.setEstado(Estado.ELIMINADO);
    tipoHabitacionService.save(tipoHabitacion);
    flash.addFlashAttribute("exito", "El tipo de habitación ha sido eliminado exitosamente");
    return "redirect:/tipo-habitacion/lista";
  }

  @PostMapping("/registrar")
  public String registrar(@ModelAttribute TipoHabitacion tipoHabitacion, RedirectAttributes flash){
    tipoHabitacion.setEstado(Estado.ACTIVO);
    tipoHabitacionService.save(tipoHabitacion);
    flash.addFlashAttribute("exito", "El tipo de habitación ha sido registrado exitosamente");
    return "redirect:/tipo-habitacion/lista";
  }

  @PostMapping("/modificar")
  public String modificar(@ModelAttribute TipoHabitacion tipoHabitacion, RedirectAttributes flash){
    tipoHabitacionService.save(tipoHabitacion);
    flash.addFlashAttribute("exito", "El tipo de habitación ha sido modificado exitosamente");
    return "redirect:/tipo-habitacion/lista";
  }
}
