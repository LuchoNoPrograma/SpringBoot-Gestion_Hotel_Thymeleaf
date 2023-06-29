package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Charts {

	@GetMapping("/charts-apex")
	public String charts_apex(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Apex Charts");
		model.addAttribute("item", "Charts");
		return "charts/charts-apex";
	}
	
	@GetMapping("/charts-echart")
	public String charts_echart(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "E Charts");
		model.addAttribute("item", "Charts");
		return "charts/charts-echart";
	}
	
	@GetMapping("/charts-chartjs")
	public String charts_chartjs(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Chartjs Charts");
		model.addAttribute("item", "Charts");
		return "charts/charts-chartjs";
	}
	
	@GetMapping("/charts-flot")
	public String charts_flot(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Flot Charts");
		model.addAttribute("item", "Charts");
		return "charts/charts-flot";
	}
	
	@GetMapping("/charts-tui")
	public String charts_tui(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Toast UI Charts");
		model.addAttribute("item", "Charts");
		return "charts/charts-tui";
	}
	
	@GetMapping("/charts-knob")
	public String charts_knob(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Jquery Knob Charts");
		model.addAttribute("item", "Charts");
		return "charts/charts-knob";
	}
	
	@GetMapping("/charts-sparkline")
	public String charts_sparkline(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Sparkline Charts");
		model.addAttribute("item", "Charts");
		return "charts/charts-sparkline";
	}
}
