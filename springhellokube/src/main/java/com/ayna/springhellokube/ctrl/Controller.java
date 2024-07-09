package com.ayna.springhellokube.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Controller {

	@GetMapping("/welcome")	
	public String helloFn() {
		return "THIS IS THE SPRING BOOT TEST APPLICATION FOR KUBERNETES ENVIRNOMENT";
	}
	
}
