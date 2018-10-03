package com.packt.webbi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping
	public String welcome(Model model) {

		return "redirect:/market/products";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
	   return "welcome";
	}

}
