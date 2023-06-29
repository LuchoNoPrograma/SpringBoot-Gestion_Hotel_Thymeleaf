package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contacts")
public class Contact {

	@GetMapping("/grid")
	public String grid(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Users Grid");
		model.addAttribute("item", "Contacts");
		return "contact/grid";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Users List");
		model.addAttribute("item", "Contacts");
		return "contact/list";
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Profile");
		model.addAttribute("item", "Contacts");
		return "contact/profile";
	}
}
