package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
public class Email {

	@GetMapping("/inbox")
	public String wallet(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Inbox");
		model.addAttribute("item", "Email");
		return "email/inbox";
	}
	
	@GetMapping("/read")
	public String wallerad(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Read Email");
		model.addAttribute("item", "Email");
		return "email/read";
	}
	
	@GetMapping("/basic-template")
	public String basic_template(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Basic Action");
		model.addAttribute("item", "Email Template");
		return "email/templates/basic";
	}
	
	@GetMapping("/alert-template")
	public String alert_template(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Alert Email");
		model.addAttribute("item", "Email Template");
		return "email/templates/alert";
	}
	
	@GetMapping("/billing-template")
	public String billing_template(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Billing Email");
		model.addAttribute("item", "Email Template");
		return "email/templates/billing";
	}
}
