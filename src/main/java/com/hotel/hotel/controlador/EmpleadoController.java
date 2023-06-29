package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Empleado;
import com.hotel.hotel.modelo.entidad.Persona;
import com.hotel.hotel.modelo.enums.Cargo;
import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.enums.EstadoCivil;
import com.hotel.hotel.modelo.enums.Sexo;
import com.hotel.hotel.modelo.servicio.interfaces.IEmpleadoService;
import com.hotel.hotel.modelo.servicio.interfaces.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/empleado")
public class EmpleadoController {
  private final IEmpleadoService empleadoService;
  private final IPersonaService personaService;

  @GetMapping("/inicio")
  public String inicio(Model model) {
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Lista de empleados");
    model.addAttribute("listaEmpleados", empleadoService.findAll());
    model.addAttribute("fragmento", "tabla");
    return "app/empleado";
  }

  @GetMapping("/formulario-registro")
  public String formularioRegistro(Model model){
    Empleado empleado = new Empleado();
    empleado.setPersona(new Persona());

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Registrar nuevo empleado");
    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "registrar");

    model.addAttribute("listaEstadosCiviles", EstadoCivil.values());
    model.addAttribute("listaSexos", Sexo.values());
    model.addAttribute("listaCargos", Cargo.values());
    model.addAttribute("empleado", empleado);
    return "app/empleado";
  }

  @GetMapping("/formulario-modificar/{idEmpleado}")
  public String formularioModificar(Model model, @PathVariable Long idEmpleado){
    Empleado empleado = empleadoService.findById(idEmpleado);

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Modificar empleado existente");
    model.addAttribute("fragmento", "formulario");
    model.addAttribute("tipoFormulario", "modificar");

    model.addAttribute("listaEstadosCiviles", EstadoCivil.values());
    model.addAttribute("listaSexos", Sexo.values());
    model.addAttribute("listaCargos", Cargo.values());
    model.addAttribute("empleado", empleado);
    return "app/empleado";
  }

  @PostMapping("/registrar")
  public String registrar(@ModelAttribute Empleado empleado, RedirectAttributes flash){
    empleado.setEstado(Estado.ACTIVO);
    empleado.getPersona().setEstado(Estado.ACTIVO);
    empleadoService.saveWithPersona(empleado);
    flash.addFlashAttribute("exito", "Empleado registrado exitosamente");
    return "redirect:/empleado/inicio";
  }

  @PostMapping("/modificar")
  public String modificar(@ModelAttribute Empleado empleado, RedirectAttributes flash){
    empleadoService.saveWithPersona(empleado);
    flash.addFlashAttribute("exito", "Empleado modificado exitosamente");
    return "redirect:/empleado/inicio";
  }


  @PostMapping("/eliminar")
  public String eliminar(@RequestParam Long idEmpleado, RedirectAttributes flash){
    Empleado empleado = empleadoService.findById(idEmpleado);
    empleado.setEstado(Estado.ELIMINADO);
    empleadoService.save(empleado);
    flash.addFlashAttribute("exito", "Empleado modificado exitosamente");
    return "redirect:/empleado/inicio";
  }
}
