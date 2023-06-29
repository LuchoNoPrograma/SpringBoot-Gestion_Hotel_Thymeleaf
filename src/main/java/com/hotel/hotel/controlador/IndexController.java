package com.hotel.hotel.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

  @GetMapping({"/", "/index","/inicio","/home"})
  public String index(Model model) {
    model.addAttribute("template", "layout");
    model.addAttribute("title", "Sistema de gestión hotelera");
    return "index";
  }

}
