package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/job")
public class Job {

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Jobs List");
		model.addAttribute("item", "Jobs");
		return "jobs/list";
	}
	
	@GetMapping("/grid")
	public String grid(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Jobs Grid");
		model.addAttribute("item", "Jobs");
		return "jobs/grid";
	}
	
	@GetMapping("/apply")
	public String apply(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Job Apply");
		model.addAttribute("item", "Jobs");
		return "jobs/apply";
	}
	
	@GetMapping("/details")
	public String details(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Job Details");
		model.addAttribute("item", "Jobs");
		return "jobs/details";
	}
	
	@GetMapping("/categories")
	public String categories(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Job Categories");
		model.addAttribute("item", "Jobs");
		return "jobs/categories";
	}
	
	@GetMapping("/candidate-list")
	public String candidat_list(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Candidate List");
		model.addAttribute("item", "Jobs");
		return "jobs/candidate-list";
	}
	
	@GetMapping("/candidate-overview")
	public String candidat_overview(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Candidate List");
		model.addAttribute("item", "Jobs");
		return "jobs/candidate-overview";
	}
}
