package com.tcl.firstspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcl.firstspringboot.entity.ArtUser;
import com.tcl.firstspringboot.repository.ArtUserRepository;
import com.tcl.firstspringboot.service.UserService;

@RestController
@RequestMapping("/api/artuser")
//@CrossOrigin(origins = "http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin",allowedHeaders = "*",
//methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.OPTIONS})

public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	public ArtUserRepository artUserRepository;

	@PostMapping("/adduser")
	public ArtUser addUser(@RequestBody ArtUser artuser) {
		return userService.addUser(artuser);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/listalluser")
	public List<ArtUser> listAllUser() {
		return userService.listAllUser();
	}

	@GetMapping("/findbyuserid/{uid}")
	public Optional<ArtUser> findByUserId(@PathVariable(value = "uid") Long uid) {
		Optional<ArtUser> user = userService.findByUserId(uid);
		return user;
	}
	

	@GetMapping("/login")	
	public ResponseEntity<ArtUser> loginrest(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		System.out.println("username ===== " + username + " -- " + "paswword -----" + password);
		System.out.println("*******This is a login rest controller ***********");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("*****************" + auth);
		ArtUser artuser = artUserRepository.findByUsername(auth.getName());
		System.out.println("After Login__________________"
				+ "send back to Angular or postman as response__________________" + artuser);
		return ResponseEntity.ok(artuser);
	}
	@GetMapping("/error") 
	public String fnError() { 
		return "Error"; 
	}

}
