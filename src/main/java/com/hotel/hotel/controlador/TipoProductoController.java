package com.hotel.hotel.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hotel.hotel.modelo.entidad.Empleado;
import com.hotel.hotel.modelo.entidad.TipoProducto;
import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.servicio.interfaces.ITipoProductoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("tipo-producto")
public class TipoProductoController {
    private final ITipoProductoService tipoProductoService;
    
    @GetMapping("/lista")
    public String lista(Model model){
        model.addAttribute("template", "layout");
        model.addAttribute("title", "Lista de Tipos de productos");
        model.addAttribute("fragmento", "tabla");
        model.addAttribute("listaTipoProductos", tipoProductoService.findAll());
        
        return "app/tipo-producto";
    }

    @GetMapping("/formulario-registro")
    public String mostrarFormularioRegistro(@ModelAttribute TipoProducto tipoProducto, Model model){
        model.addAttribute("template", "layout");
        model.addAttribute("title", "Registrar nuevo tipo de producto");
        model.addAttribute("fragmento", "formulario");
        model.addAttribute("tipoFormulario", "registrar");
        model.addAttribute("tipoProducto", tipoProducto);
        return "app/tipo-producto";
    }

    @GetMapping("/formulario-modificar/{idTipoProducto}")
    public String modificar(@PathVariable Long idTipoProducto ,Model model){

        TipoProducto tipoProducto =  tipoProductoService.findById(idTipoProducto);
        model.addAttribute("template", "layout");
        model.addAttribute("title", "Modificar Tipo producto Existente");
        model.addAttribute("fragmento", "formulario");
        model.addAttribute("tipoFormulario", "modificar");
        model.addAttribute("tipoProducto", tipoProducto);
        return "app/tipo-producto";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long idTipoProducto, RedirectAttributes flash){
    TipoProducto tipoProducto = tipoProductoService.findById(idTipoProducto);
    tipoProducto.setEstado(Estado.ELIMINADO);
    tipoProductoService.save(tipoProducto);
    flash.addFlashAttribute("exito", "Tipo producto ha sido eliminado exitosamente");
    return "redirect:/tipo-producto/inicio";
  }
    
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute TipoProducto tipoProducto, RedirectAttributes flash){
    tipoProducto.setEstado(Estado.ACTIVO);
    tipoProductoService.save(tipoProducto);
    flash.addFlashAttribute("exito", "Tipo de producto registrado exitosamente");
    return "redirect:/tipo-producto/lista";
  }

  @PostMapping("/modificar")
    public String modificar(@ModelAttribute TipoProducto tipoProducto, RedirectAttributes flash){
    tipoProductoService.save(tipoProducto);
    flash.addFlashAttribute("exito", "Tipo de producto modificado exitosamente");
    return "redirect:/tipo-producto/lista";
  }

}
