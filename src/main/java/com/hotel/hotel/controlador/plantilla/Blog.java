package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class Blog {

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Blog List");
		model.addAttribute("item", "Blog");
		return "blog/list";
	}
	
	@GetMapping("/grid")
	public String grid(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Blog Grid");
		model.addAttribute("item", "Blog");
		return "blog/grid";
	}
	
	@GetMapping("/details")
	public String details(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Blog Details");
		model.addAttribute("item", "Blog");
		return "blog/details";
	}
}
