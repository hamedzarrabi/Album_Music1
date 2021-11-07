package com.hamed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	
	@GetMapping("")
	public String goHome() {
		return "index";
	}
	
	@GetMapping("login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("contact")
	public String contactPage() {
		return "contact";
	}

	@GetMapping("register")
	public String registerPage() {
		return "register";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/blog")
	public String blog() {
		return "blog";
	}

	@GetMapping("/portfolio")
	public String portfolio() {
		return "portfolio";
	}

	@GetMapping("services_album")
	public String service() {
		return "services_album";
	}

}
