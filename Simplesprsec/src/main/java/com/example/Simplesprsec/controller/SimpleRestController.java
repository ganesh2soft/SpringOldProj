package com.example.Simplesprsec.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruits")
public class SimpleRestController {
	
@GetMapping("")
public String Welcome() {
	return " Welcome to FRUIT SHOP";
}


@GetMapping("/strawberry")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public String strawshop() {
	return " Welcome to STRAWBERRY STRAWBERRYSTRAWBERRYSTRAWBERRYSTRAWBERRY World";
}

@GetMapping("/mango")
@PreAuthorize("hasAuthority('ROLE_USER)")
public String mangoshop() {
	return " Welcome to Mango World Welcome to Mango World Welcome to Mango World";
}

@GetMapping("/apple")
@PreAuthorize("hasAuthority('ROLE_USER')")
public String appleshop() {
	return " Welcome to APPLE APPLE  Universe";
}

}
