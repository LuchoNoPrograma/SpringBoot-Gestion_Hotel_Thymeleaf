package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoices")
public class Invoices {

	@GetMapping("/list")
	public String wallet(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Invoice List");
		model.addAttribute("item", "Invoices");
		return "invoice/list";
	}
	
	@GetMapping("/detail")
	public String detail(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Detail");
		model.addAttribute("item", "Invoices");
		return "invoice/detail";
	}
}
