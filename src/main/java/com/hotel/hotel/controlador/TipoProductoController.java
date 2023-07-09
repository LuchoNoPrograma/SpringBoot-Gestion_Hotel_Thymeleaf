package com.hotel.hotel.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.hotel.modelo.servicio.interfaces.ITipoProductoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("tipo-producto")
public class TipoProductoController {
    private final ITipoProductoService tipoProductoService;
    
    @GetMapping("/lista")
    public String lista(Model model){
        return "app/tipo-producto";
    }

    @GetMapping("/formulario-registro")
    public String mostrarFormularioRegistro(Model model){
        return "app/tipo-producto";
    }

    @GetMapping("/modificar")
    public String modificar(Model model){
        return "app/tipo-producto";
    }

    @PostMapping("/eliminar")
    public String eliminar();
}
