package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class Pages {

	@GetMapping("/starter")
	public String list(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Starter Page");
		model.addAttribute("item", "Utility");
		return "pages/starter";
	}
	
	@GetMapping("/maintenance")
	public String maintenance(Model model) {
		model.addAttribute("template", "layout");
//		model.addAttribute("title", "Starter Page");
//		model.addAttribute("item", "Utility");
		return "pages/maintenance";
	}
	
	@GetMapping("/comingsoon")
	public String comingsoon(Model model) {
		return "pages/comingsoon";
	}
	
	@GetMapping("/timeline")
	public String timeline(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Timeline");
		model.addAttribute("item", "Utility");
		return "pages/timeline";
	}
	
	@GetMapping("/faqs")
	public String faqs(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "FAQs");
		model.addAttribute("item", "Utility");
		return "pages/faqs";
	}
	
	@GetMapping("/pricing")
	public String pricing(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Pricing");
		model.addAttribute("item", "Utility");
		return "pages/pricing";
	}
	
	@GetMapping("/404")
	public String pages_not_found(Model model) {
//		model.addAttribute("template", "layout");
//		model.addAttribute("title", "Pricing");
//		model.addAttribute("item", "Utility");
		return "pages/404";
	}
	
	@GetMapping("/500")
	public String pages_internal_server(Model model) {
//		model.addAttribute("template", "layout");
//		model.addAttribute("title", "Pricing");
//		model.addAttribute("item", "Utility");
		return "pages/500";
	}
}
