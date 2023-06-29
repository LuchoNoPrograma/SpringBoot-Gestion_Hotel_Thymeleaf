package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Tables {
	
	@GetMapping("/tables-basic")
	public String tables_basic(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Basic Tables");
		model.addAttribute("item", "Tables");
		return "tables/tables-basic";
	}
	
	@GetMapping("/tables-datatable")
	public String tables_datatable(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Data Tables");
		model.addAttribute("item", "Tables");
		return "tables/tables-datatable";
	}
	
	@GetMapping("/tables-responsive")
	public String tables_responsive(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Responsive Table");
		model.addAttribute("item", "Tables");
		return "tables/tables-responsive";
	}
	
	@GetMapping("/tables-editable")
	public String tables_editable(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Editable Table");
		model.addAttribute("item", "Tables");
		return "tables/tables-editable";
	}
}
