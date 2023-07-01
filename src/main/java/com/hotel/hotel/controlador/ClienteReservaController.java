package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Cliente;
import com.hotel.hotel.modelo.servicio.interfaces.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ClienteReservaController {
  private final IClienteService clienteService;


  @GetMapping("/agregar-reserva")
  public String formularioReserva(@ModelAttribute Cliente cliente, Model model) {
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Registrar nuevo empleado");
    model.addAttribute("fragmento", "formulario-reserva");

    return "app/cliente-reserva";
  }

  @PostMapping("/registrar-reserva")
  public String registrarReserva(@ModelAttribute Cliente cliente, RedirectAttributes flash) {
    return "app/cliente";
  }
}
