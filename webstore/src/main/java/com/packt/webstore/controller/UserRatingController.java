package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.service.UserService;

@RestController
@RequestMapping(value = "rest/userrating")
public class UserRatingController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateReviewToDB(@RequestParam(value = "point", required = false, defaultValue = "0") int point,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "productId", required = false) String productId) {
		
		userService.updateUserRating(point, username, productId);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	int initUserRating(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "productId", required = false) String productId){
		return userService.getUserRating(username, productId);
	} 
}
