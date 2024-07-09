package com.cts.deptboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class DeptbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeptbootApplication.class, args);
	}
	
//	@Bean
//	public RestTemplate deptRestTemplate() {
//		return new RestTemplate();
//	}

}
