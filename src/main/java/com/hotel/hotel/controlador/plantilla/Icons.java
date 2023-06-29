package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Icons {

	@GetMapping("/icons-boxicons")
	public String icons_boxicons(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Boxicons");
		model.addAttribute("item", "Icons");
		return "icons/boxicons";
	}
	
	@GetMapping("/icons-materialdesign")
	public String icons_materialdesign(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Material Design Icons");
		model.addAttribute("item", "Icons");
		return "icons/materialdesign";
	}
	
	@GetMapping("/icons-dripicons")
	public String icons_dripicons(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Dripicons");
		model.addAttribute("item", "Icons");
		return "icons/dripicons";
	}
	
	@GetMapping("/icons-fontawesome")
	public String icons_fontawesome(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Font Awesome");
		model.addAttribute("item", "Icons");
		return "icons/fontawesome";
	}
}
