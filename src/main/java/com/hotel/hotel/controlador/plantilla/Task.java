package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class Task {

	@GetMapping("/list")
	public String grid(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Task List");
		model.addAttribute("item", "Tasks");
		return "task/list";
	}
	
	@GetMapping("/kanban")
	public String kanban(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Kanban Board");
		model.addAttribute("item", "Tasks");
		return "task/kanban";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Create Task");
		model.addAttribute("item", "Tasks");
		return "task/create";
	}
}
