package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormElement {

	@GetMapping("/form-elements")
	public String form_elements(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form Elements");
		model.addAttribute("item", "Forms");
		return "forms/form-elements";
	}
	
	@GetMapping("/form-layouts")
	public String form_layouts(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form Layouts");
		model.addAttribute("item", "Forms");
		return "forms/form-layouts";
	}
	
	@GetMapping("/form-validation")
	public String form_validation(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form Validation");
		model.addAttribute("item", "Forms");
		return "forms/form-validation";
	}
	
	@GetMapping("/form-advanced")
	public String form_advanced(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form Advanced");
		model.addAttribute("item", "Forms");
		return "forms/form-advanced";
	}
	
	@GetMapping("/form-editors")
	public String form_editors(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form editorsd");
		model.addAttribute("item", "Forms");
		return "forms/form-editors";
	}
	
	@GetMapping("/form-uploads")
	public String form_uploads(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form File Upload");
		model.addAttribute("item", "Forms");
		return "forms/form-uploads";
	}
	
	@GetMapping("/form-xeditable")
	public String form_xeditable(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form Xeditable");
		model.addAttribute("item", "Forms");
		return "forms/form-xeditable";
	}
	
	@GetMapping("/form-repeater")
	public String form_repeater(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form Repeater");
		model.addAttribute("item", "Forms");
		return "forms/form-repeater";
	}
	
	@GetMapping("/form-wizard")
	public String form_wizard(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form Wizard");
		model.addAttribute("item", "Forms");
		return "forms/form-wizard";
	}
	
	@GetMapping("/form-mask")
	public String form_mask(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Form Mask");
		model.addAttribute("item", "Forms");
		return "forms/form-mask";
	}
}
