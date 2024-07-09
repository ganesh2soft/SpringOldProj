package com.deeps.sprbootauthdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.deeps.sprbootauthdemo.model.Users;
import com.deeps.sprbootauthdemo.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserRepository userRepository;
	
	
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/addAdmin")
	public String addUserByAdmin(@RequestBody Users user) {
		String pwd = user.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		userRepository.save(user);
		return "User Added Successfully ...";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/all")
	public String securedHello() {
		return "Secured Hello";
	}
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
}














