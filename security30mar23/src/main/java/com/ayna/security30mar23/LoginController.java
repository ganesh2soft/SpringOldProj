package com.ayna.security30mar23;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController
@RequestMapping("/parent")
public class LoginController {

	
	@GetMapping("/home")		
	public String home() {
		return "home";
	}
	
}
