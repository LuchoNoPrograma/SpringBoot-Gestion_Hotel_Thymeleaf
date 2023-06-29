package com.hotel.hotel.controlador.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ecommerce")
public class Ecommerce {

	@GetMapping("/products")
	public String products(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Products");
		model.addAttribute("item", "Ecommerce");
//		model.addAttribute("subitem", "Dashboard"); 
		return "ecommerce/products";
	}
	
	@GetMapping("/product-detail")
	public String products_detail(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Product Detail");
		model.addAttribute("item", "Ecommerce");
		return "ecommerce/product-detail";
	}
	
	@GetMapping("/orders")
	public String orders(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Orders");
		model.addAttribute("item", "Ecommerce");
		return "ecommerce/orders";
	}
	
	@GetMapping("/customers")
	public String customers(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Customers");
		model.addAttribute("item", "Ecommerce");
		return "ecommerce/customers";
	}
	
	@GetMapping("/cart")
	public String cart(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Cart");
		model.addAttribute("item", "Ecommerce");
		return "ecommerce/cart";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Checkout");
		model.addAttribute("item", "Ecommerce");
		return "ecommerce/checkout";
	}
	
	@GetMapping("/shops")
	public String shops(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Shops");
		model.addAttribute("item", "Ecommerce");
		return "ecommerce/shops";
	}
	
	@GetMapping("/add-product")
	public String add_product(Model model) {
		model.addAttribute("template", "layout");
		model.addAttribute("title", "Add Product");
		model.addAttribute("item", "Ecommerce");
		return "ecommerce/add_product";
	}
}
