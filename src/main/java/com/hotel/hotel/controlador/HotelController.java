package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.servicio.interfaces.IHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {
  private final IHotelService hotelService;

  @GetMapping("/inicio")
  public String index(Model model) {
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Administrar hotel");
    model.addAttribute("fragmento", "carta");
    return "app/hotel";
  }

  @GetMapping("/formulario-registro")
  public String formularioRegistro(Model model){
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Registrar hotel");
    model.addAttribute("fragmento", "formulario");
    return "app/hotel";
  }

  @GetMapping("/formulario-modificar/{idHotel}")
  public String formularioModificar(Model model, @PathVariable Long idHotel){
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Modificar hotel");
    model.addAttribute("fragmento", "formulario");
    return "app/hotel";
  }
}
