package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import com.hotel.hotel.modelo.servicio.interfaces.IHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
  private final IHabitacionService habitacionService;

  @GetMapping({"/", "/index","/inicio","/home"})
  public String index(@RequestParam(value = "estado", required = false) EstadoHabitacion estadoHabitacion, Model model){
    return "redirect:/habitacion/lista";
  }

}
