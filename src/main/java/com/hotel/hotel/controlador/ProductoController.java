package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Empleado;
import com.hotel.hotel.modelo.entidad.Persona;
import com.hotel.hotel.modelo.entidad.Producto;
import com.hotel.hotel.modelo.entidad.TipoProducto;
import com.hotel.hotel.modelo.enums.Cargo;
import com.hotel.hotel.modelo.enums.Estado;
import com.hotel.hotel.modelo.enums.EstadoCivil;
import com.hotel.hotel.modelo.enums.Sexo;
import com.hotel.hotel.modelo.servicio.interfaces.IEmpleadoService;
import com.hotel.hotel.modelo.servicio.interfaces.IPersonaService;
import com.hotel.hotel.modelo.servicio.interfaces.IProductoService;

import com.hotel.hotel.modelo.servicio.interfaces.ITipoProductoService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/producto")
public class ProductoController {
  private final IProductoService productoService;
  private final ITipoProductoService tipoProductoService;

  @GetMapping("/lista")
  public String inicio(Model model,
                       @RequestParam(value = "tipo", required = false) Long idTipo,
                       @RequestParam(value = "orden", defaultValue = "nombreProducto") String orden) {
    List<Producto> listaProductos;
    List<TipoProducto> listaTipoProductos = tipoProductoService.findAllDistinctEliminado(Sort.by("nombreTipoProducto"));
    Sort sort = Sort.by("nombreProducto");
    if (idTipo != null) {
      listaProductos = productoService.findAllByTipoProducto(idTipo, sort);
    }else{
      listaProductos = productoService.findAllByTipoProducto(listaTipoProductos.get(0).getIdTipoProducto(), sort);
    }
    model.addAttribute("listaTiposProductos", listaTipoProductos);
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Lista de empleados");
    model.addAttribute("listaProductos", listaProductos);
    model.addAttribute("fragmento", "tabla");
    return "app/producto";
  }

  @GetMapping("/formulario-registro")
  public String formularioRegistro(@ModelAttribute Producto producto ,Model model){
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Registrar nuevo producto");
    model.addAttribute("fragmento", "formulario");
    Sort orden = Sort.by("nombreTipoProducto");
    model.addAttribute("listaTiposProductos", tipoProductoService.findAllDistinctEliminado(orden));
    model.addAttribute("tipoFormulario", "registrar");
    model.addAttribute("producto", producto);
    return "app/producto";
  }

  @GetMapping("/formulario-modificar/{idProducto}")
  public String formularioModificar(Model model, @PathVariable Long idProducto){
    Producto producto = productoService.findById(idProducto);

    model.addAttribute("template", "layout");
    model.addAttribute("title", "Modificar producto existente");
    model.addAttribute("fragmento", "formulario");
    Sort orden = Sort.by("nombreTipoProducto");
    model.addAttribute("listaTiposProductos", tipoProductoService.findAllDistinctEliminado(orden));
    model.addAttribute("tipoFormulario", "modificar");
    model.addAttribute("producto", producto);
    return "app/producto";
  }

  @PostMapping("/registrar")
  public String registrar(@ModelAttribute Producto producto, RedirectAttributes flash){
    producto.setEstado(Estado.ACTIVO);
    productoService.save(producto);
    flash.addFlashAttribute("exito", "Producto registrado exitosamente");
    return "redirect:/producto/lista";
  }

  @PostMapping("/modificar")
  public String modificar(@ModelAttribute Producto producto, RedirectAttributes flash){
    productoService.save(producto);
    flash.addFlashAttribute("exito", "Producto modificado exitosamente");
    return "redirect:/producto/lista";
  }


  @PostMapping("/eliminar")
  public String eliminar(@RequestParam Long idProducto, RedirectAttributes flash){
    Producto producto = productoService.findById(idProducto);
    producto.setEstado(Estado.ELIMINADO);
    productoService.save(producto);
    flash.addFlashAttribute("exito", "Producto eliminado exitosamente");
    return "redirect:/producto/lista";
  }
}
