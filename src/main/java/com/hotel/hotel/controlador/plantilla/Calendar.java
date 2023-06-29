package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Calendar {

	@GetMapping("/calendar")
	public String index(Model model) {
//		model.addAttribute("template", "layout");
		model.addAttribute("title", "TUI Calendar");
		model.addAttribute("item", "Calender");
		model.addAttribute("subitem", "TUI Calendar");
		return "calendar/index";
	}
	
	@GetMapping("/calendar-full")
	public String calendar_full(Model model) {
//		model.addAttribute("template", "layout");
		model.addAttribute("title", "Full Calendar");
		model.addAttribute("item", "Calender");
		model.addAttribute("subitem", "Full Calendar");
		return "calendar/calendar-full";
	}
}
