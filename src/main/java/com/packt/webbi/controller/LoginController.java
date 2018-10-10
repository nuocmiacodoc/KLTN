package com.packt.webbi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login() {
      return "login";
   }
}
