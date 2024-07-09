package com.ayna.ems22.configuration;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class Ems22SecConfig {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		  .requestMatchers("/joinee/**").permitAll()
		  .requestMatchers("/joinee/register/**").permitAll()
		  .requestMatchers("/joinee/addjoinee/**").permitAll()
		  .anyRequest().authenticated()
          .and()
          .httpBasic()
          .and()
          .csrf().disable();
//	      .logout()
//		  .logoutSuccessHandler(new LogoutSuccessHandler() {
//			  
//			@Override
//			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
//					Authentication authentication) throws IOException, ServletException {
//			System.out.println("The user is " + authentication.getName()+ "has been logged out");
//			}
//			
//		  }) 
			
	    http.logout(logout -> logout.permitAll()
	                .logoutSuccessHandler((request, response, authentication) -> {
	                    response.setStatus(HttpServletResponse.SC_OK);
	                }));
	           
		       
	    return http.build();
    }
}
