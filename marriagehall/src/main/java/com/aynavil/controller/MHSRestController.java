package com.aynavil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aynavil.entity.Booking;
import com.aynavil.entity.Userdetails;
import com.aynavil.service.BookingService;
import com.aynavil.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class MHSRestController {
	@Autowired
	public UserService userservice;
	
	
	@PostMapping("/createUser")
	public Userdetails createUser(@RequestBody Userdetails userdetails) {
		userservice.createUser(userdetails);
		return userdetails;
	}

}
