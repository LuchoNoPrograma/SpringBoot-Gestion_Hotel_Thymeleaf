package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.servicio.interfaces.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ClienteController {
  private final IClienteService clienteService;
}
