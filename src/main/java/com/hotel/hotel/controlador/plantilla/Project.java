package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("project")
public class Project {

	@GetMapping("/grid")
	public String grid(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Projects Grid");
		model.addAttribute("item", "Projects");
		return "project/grid";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Projects List");
		model.addAttribute("item", "Projects");
		return "project/list";
	}
	
	@GetMapping("/overview")
	public String overview(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Project Overview");
		model.addAttribute("item", "Projects");
		return "project/overview";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Create New");
		model.addAttribute("item", "Project");
		return "project/create";
	}
}
