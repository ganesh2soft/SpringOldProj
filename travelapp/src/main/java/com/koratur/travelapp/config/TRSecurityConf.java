package com.koratur.travelapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.koratur.travelapp.filters.JWTTokenGeneratorFilter;
import com.koratur.travelapp.filters.JWTValidateFilter;

import java.util.Arrays;
@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
@SuppressWarnings("unused")
public class TRSecurityConf  {
 
	@Autowired
	 TRAuthProvider ap;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		http.authorizeHttpRequests()
		.requestMatchers("/welcome/**").permitAll()
		.requestMatchers("/login/**").permitAll()
		.requestMatchers("/listtour/**").permitAll()
		.requestMatchers("/v2/api-docs",
				"/v3/api-docs/**",
				"/swagger-resources/configuration/ui",  
				"/swagger-resources/configuration/security", 
				"/webjars/**",
				"/swagger-ui.html","/swagger-ui/**").permitAll()
		// Line 43 is very important
		.requestMatchers("/requestlocaltour/**").authenticated()
		.requestMatchers("/requestforeigntour/**").authenticated()
		
		.requestMatchers("/addtraveller/**").authenticated()
		.requestMatchers("/listtravellers/**").permitAll()
		.requestMatchers("/fetchdetailsbyjoins/{travellerid}").permitAll()
		.and()
		.httpBasic();
				http.cors();
		http.csrf().disable(); //403forbidden error
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class);
		http.addFilterBefore(new JWTValidateFilter(), BasicAuthenticationFilter.class);
		return http.build();
	}
	@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*"); // this allows all origin
        config.addAllowedHeader("*"); // this allows all headers
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.setExposedHeaders(Arrays.asList("Authorization"));
        config.setMaxAge((long) 3600000);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(ap);
		return authenticationManagerBuilder.build();
	}
	}
