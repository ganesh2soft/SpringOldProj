package com.aynavil.tourapp.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@AllArgsConstructor
@Getter
@Setter
@Component
@NoArgsConstructor
public class EndUser {
		
		private String username;
		private String password;
		
	
}
