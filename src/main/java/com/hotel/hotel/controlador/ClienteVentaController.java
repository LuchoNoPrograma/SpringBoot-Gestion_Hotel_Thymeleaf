package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Documento;
import com.hotel.hotel.modelo.entidad.Habitacion;
import com.hotel.hotel.modelo.servicio.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/venta")
public class ClienteVentaController {
  private final IClienteService clienteService;
  private final IPersonaService personaService;
  private final IHabitacionService habitacionService;
  private final IDocumentoService documentoService;
  private final IDetalleDocumentoService detalleDocumentoService;
  private final IClienteDocumentoService clienteDocumentoService;

  @GetMapping("/formulario-servicio-habitacion/{idHabitacion}")
  public String formularioServicioHabitacion(@PathVariable Long idHabitacion, @ModelAttribute Documento documento,
                                             Model model){
    Habitacion habitacion = habitacionService.findById(idHabitacion);

    model.addAttribute("documento", documento);
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Servicio a la habitación "+habitacion.getNroHabitacion());
    model.addAttribute("fragmento", "formulario-servicio-habitacion");
    return "app/cliente-venta";
  }
}
