package com.hamed;

import com.hamed.model.User;
import com.hamed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicationController {

	@Autowired
	UserService userService;

	@GetMapping("")
	public String goHome() {
		return "index";
	}

//	@GetMapping("/admin")
//	public String goAdminPage() {
//		return "admin";
//	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/logout")
	public String logoutPage() {
		return "index";
	}

	@GetMapping("contact")
	public String contactPage() {
		return "contact";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
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

	@PostMapping("/process_register")
	public String processRegister(User user) {
		userService.saveUserWithDefaultRole(user);
		return "index";
	}




}
