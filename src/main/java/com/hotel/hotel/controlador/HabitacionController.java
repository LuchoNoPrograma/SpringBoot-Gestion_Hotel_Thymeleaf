package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.servicio.interfaces.IHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/habitacion")
public class HabitacionController {
  private final IHabitacionService habitacionService;

  @GetMapping("/inicio")
  public String index(Model model){
    return "app/habitacion";
  }

  @GetMapping("/formulario-registrar")
  public String mostrarFormulario(@ModelAttribute Habitacion habitacion){
    return "app/habitacion";
  }

  @PostMapping("/registrar")
  public String registrar(Model model){
    return "app/habitacion";
  }
}
