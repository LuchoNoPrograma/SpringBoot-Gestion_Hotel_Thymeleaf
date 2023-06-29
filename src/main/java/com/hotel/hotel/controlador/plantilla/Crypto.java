package com.hotel.hotel.controlador.plantilla;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crypto")
public class Crypto {

	@GetMapping("/wallet")
	public String wallet(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Wallet");
		model.addAttribute("item", "Crypto");
		return "crypto/wallet";
	}
	
	@GetMapping("/buy-sell")
	public String buy_sell(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Buy/Sell");
		model.addAttribute("item", "Crypto");
		return "crypto/buy-sell";
	}
	
	@GetMapping("/exchange")
	public String exchange(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Exchange");
		model.addAttribute("item", "Crypto");
		return "crypto/exchange";
	}
	
	@GetMapping("/lending")
	public String lending(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Lending");
		model.addAttribute("item", "Crypto");
		return "crypto/lending";
	}
	
	@GetMapping("/orders")
	public String orders(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Orders");
		model.addAttribute("item", "Crypto");
		return "crypto/orders";
	}
	
	@GetMapping("/kyc-application")
	public String kyc_application(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "KYC Application");
		model.addAttribute("item", "Crypto");
		return "crypto/kyc-application";
	}
	
	@GetMapping("/ico-landing")
	public String ico_landing(Model model) {
		/*model.addAttribute("template", "layout");
		model.addAttribute("item", "Crypto");*/
		model.addAttribute("title", "KYC Application");
		return "crypto/ico-landing";
	}
}
