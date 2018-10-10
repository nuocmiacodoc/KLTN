package com.packt.webbi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webbi.domain.User;
import com.packt.webbi.service.OrderService;
import com.packt.webbi.service.SecurityService;
import com.packt.webbi.service.UserService;
import com.packt.webbi.validator.UserValidator;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
		
		User user = new User();
        model.addAttribute("userForm", user);

        return "register";
    }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(userForm);
        securityService.autologin(userForm.getName(), userForm.getPasswordConfirm());
        return "redirect:/";
    }
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getUserInfo(Model model, Principal principal) {
		try {
		String username = principal.getName();
		System.out.println(username);
		model.addAttribute("username", username);
		model.addAttribute("userorders",orderService.getAllOrdersByUsername(username));
		model.addAttribute("userpoint", userService.getUserPoint(username));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/";
		}
		return "userInfomation";
	}
}
