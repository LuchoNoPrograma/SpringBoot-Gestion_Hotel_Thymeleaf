package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIElement {

	@GetMapping("/ui-alerts")
	public String ui_alerts(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Alerts");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-alerts";
	}
	
	@GetMapping("/ui-buttons")
	public String ui_buttons(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Buttons");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-buttons";
	}
	
	@GetMapping("/ui-cards")
	public String ui_cards(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Cards");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-cards";
	}
	
	@GetMapping("/ui-carousel")
	public String ui_carousel(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Carousel");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-carousel";
	}
	
	@GetMapping("/ui-dropdowns")
	public String ui_dropdowns(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Dropdowns");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-dropdowns";
	}
	
	@GetMapping("/ui-grid")
	public String ui_grid(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Grid");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-grid";
	}
	
	@GetMapping("/ui-images")
	public String ui_images(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Images");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-images";
	}
	
	@GetMapping("/ui-lightbox")
	public String ui_lightbox(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Lightbox");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-lightbox";
	}
	
	@GetMapping("/ui-modals")
	public String ui_modals(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Modals");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-modals";
	}
	
	@GetMapping("/ui-offcanvas")
	public String ui_offcanvas(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Offcanvas");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-offcanvas";
	}
	
	@GetMapping("/ui-rangeslider")
	public String ui_rangeslider(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Range Slider");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-rangeslider";
	}
	
	@GetMapping("/ui-session-timeout")
	public String ui_session_timeout(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Session Timeout");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-session-timeout";
	}
	
	@GetMapping("/ui-progressbars")
	public String ui_progressbars(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Progress Bars");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-progressbars";
	}
	
	@GetMapping("/ui-placeholders")
	public String ui_placeholders(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Placeholders");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-placeholders";
	}
	
	@GetMapping("/ui-sweet-alert")
	public String ui_sweet_alert(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "SweetAlert 2");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-sweet-alert";
	}
	
	@GetMapping("/ui-tabs-accordions")
	public String ui_tabs_accordions(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Tabs & Accordions");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-tabs-accordions";
	}
	
	@GetMapping("/ui-typography")
	public String ui_typography(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Typography");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-typography";
	}
	
	@GetMapping("/ui-toasts")
	public String ui_toasts(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Toasts");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-toasts";
	}
	
	@GetMapping("/ui-video")
	public String ui_video(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Video");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-video";
	}
	
	@GetMapping("/ui-general")
	public String ui_general(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "General UI");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-general";
	}
	
	@GetMapping("/ui-colors")
	public String ui_colors(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Colors");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-colors";
	}
	
	@GetMapping("/ui-rating")
	public String ui_rating(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Rating");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-rating";
	}
	
	@GetMapping("/ui-notifications")
	public String ui_notifications(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Notifications");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-notifications";
	}
	
	@GetMapping("/ui-utilities")
	public String ui_utilities(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Utilities");
		model.addAttribute("item", "UI Elements");
		return "uielement/ui-utilities";
	}
}
