package com.packt.webstore.service;

public interface SecurityService {

	   String findLoggedInUsername();

	    void autologin(String username, String password);
}
