package com.aynavil.tourapp;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class TourappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourappApplication.class, args);
	}

}
