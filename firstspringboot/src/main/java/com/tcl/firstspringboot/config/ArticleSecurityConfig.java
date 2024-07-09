package com.tcl.firstspringboot.config;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.tcl.firstspringboot.filters.CsrfCookieFilter;
import com.tcl.firstspringboot.repository.ArtUserRepository;
import com.tcl.firstspringboot.repository.ArticleRepository;


@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
@SuppressWarnings("unused")
public class ArticleSecurityConfig {
	
	@Autowired
	ArticleAuthProvider ap;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		CsrfTokenRequestAttributeHandler requestHandler=new CsrfTokenRequestAttributeHandler();
		requestHandler.setCsrfRequestAttributeName("_csrf");
		http
		.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
			
		http.authorizeHttpRequests()
		.requestMatchers("/api/article/welcome").permitAll()		
		.requestMatchers("/v2/api-docs",
				"/v3/api-docs/**",
				"/swagger-resources/configuration/ui",  
				"/swagger-resources/configuration/security", 
				"/webjars/**",
				"/swagger-ui.html","/swagger-ui/**").permitAll()
		
		.requestMatchers("/api/article/addarticle").authenticated()
		.requestMatchers("/api/article/findbyid/**").authenticated()
		.requestMatchers("/api/article/updateart/**").authenticated()
		.requestMatchers("/api/article/deleteart/**").authenticated()
		.requestMatchers("/api/artuser/login").permitAll()
		.requestMatchers("/api/artuser/adduser").permitAll()
		.requestMatchers("/api/artuser/findbyuserid/**").authenticated()
		.requestMatchers("/api/artuser/listalluser").permitAll()
		//.requestMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
		.requestMatchers("/api/article/listall").permitAll().and().httpBasic();

		  
		
		http

		.csrf().requireCsrfProtectionMatcher(
				new AntPathRequestMatcher("/payroll/allemployeeshdlr"))
		.and()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		
		
		.csrf().csrfTokenRequestHandler(requestHandler)
		.and()
		.csrf().ignoringRequestMatchers("/payroll/noticeshdlr/**");

http.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public CorsFilter corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.addAllowedOrigin("http://localhost:4200"); // Adjust the origin as needed
	    configuration.addAllowedMethod("*");
	    configuration.addAllowedHeader("*");
	    configuration.setAllowCredentials(true);
	    configuration.setExposedHeaders(Arrays.asList("authorization"));
	    configuration.setMaxAge((long) 3600000);
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return  new CorsFilter(source);
	}
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(ap);
		return authenticationManagerBuilder.build();
	}
}
