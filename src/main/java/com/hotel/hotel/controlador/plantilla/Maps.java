package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Maps {

	@GetMapping("/maps-google")
	public String icons_boxicons(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Google Maps");
		model.addAttribute("item", "Maps");
		return "maps/google";
	}
	
	@GetMapping("/maps-vector")
	public String icons_vector(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Vector Maps");
		model.addAttribute("item", "Maps");
		return "maps/vector";
	}
	
	@GetMapping("/maps-leaflet")
	public String icons_leaflet(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Leaflet Maps");
		model.addAttribute("item", "Maps");
		return "maps/leaflet";
	}
}
