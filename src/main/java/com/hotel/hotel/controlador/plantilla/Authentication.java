package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class Authentication {

	@GetMapping("/login")
	public String login(Model model) {
		return "auth/login";
	}
	
	@GetMapping("/login-2")
	public String login2(Model model) {
		return "auth/login-2";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		return "auth/register";
	}
	
	@GetMapping("/register-2")
	public String register2(Model model) {
		return "auth/register-2";
	}
	
	@GetMapping("/recoverpw")
	public String recoverpw(Model model) {
		return "auth/recoverpw";
	}
	
	@GetMapping("/recoverpw-2")
	public String recoverpw2(Model model) {
		return "auth/recoverpw-2";
	}
	
	@GetMapping("/lock-screen")
	public String lock_screen(Model model) {
		return "auth/lock-screen";
	}
	
	@GetMapping("/lock-screen-2")
	public String lock_screen2(Model model) {
		return "auth/lock-screen-2";
	}
	
	@GetMapping("/confirm-mail")
	public String confirm_mail(Model model) {
		return "auth/confirm-mail";
	}
	
	@GetMapping("/confirm-mail-2")
	public String confirm_mail2(Model model) {
		return "auth/confirm-mail-2";
	}
	
	@GetMapping("/email-verification")
	public String email_verification(Model model) {
		return "auth/email-verification";
	}
	
	@GetMapping("/email-verification-2")
	public String email_verification2(Model model) {
		return "auth/email-verification-2";
	}
	
	@GetMapping("/two-step-verification")
	public String two_step_verification(Model model) {
		return "auth/two-step-verification";
	}
	
	@GetMapping("/two-step-verification-2")
	public String two_step_verification2(Model model) {
		return "auth/two-step-verification-2";
	}
}
