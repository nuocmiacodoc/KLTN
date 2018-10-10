package com.packt.webbi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping
	public String home(Model model) {

		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
	   return "welcome";
	}

}
