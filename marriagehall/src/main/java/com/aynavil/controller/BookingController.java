package com.aynavil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aynavil.entity.Booking;
import com.aynavil.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class BookingController {
	
	@Autowired
	BookingService bookingservice;
	
	@PostMapping("/bookhall")
	public Booking Bookhall(@RequestBody Booking booking) {
		bookingservice.Bookhall(booking);
		return booking;
	}

}
