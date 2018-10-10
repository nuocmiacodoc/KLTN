package com.packt.webbi.service;

public interface SecurityService {

	   String findLoggedInUsername();

	    void autologin(String username, String password);
}
