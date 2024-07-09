package com.aynavil.tourapp.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
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

import com.aynavil.tourapp.filters.JWTTokenGeneratorFilter;
import com.aynavil.tourapp.filters.JWTValidateFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
public class TourSecurityConfiguration  {
 
	@Autowired
	TourAuthProvider ap;
	 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			
		http.authorizeHttpRequests()
		.requestMatchers("/welcome/**").permitAll()
		.requestMatchers("/listcustomers/**").authenticated()
		.requestMatchers("/myoffers/**").permitAll()
		.requestMatchers("/actuator/mapping/**").permitAll()
		
		.requestMatchers("/actuator/**").permitAll()
		.requestMatchers("/actuator/health").permitAll()
		.requestMatchers("/actuator/beans/**").permitAll()		
		.requestMatchers("/login").permitAll()
		.requestMatchers("/signup").permitAll()
		.requestMatchers("/v2/api-docs",
				"/v3/api-docs/**",
				"/swagger-resources/configuration/ui",  
				"/swagger-resources/configuration/security", 
				"/webjars/**",
				"/swagger-ui.html","/swagger-ui/**").permitAll();
		// Line 43 is very important
		
		http.httpBasic();
		
	//	http.httpBasic(Customizer.withDefaults());
				http.cors();
			//	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//http.csrf().disable(); //403forbidden error
		 http.csrf(csrf -> csrf.disable());
		  http.sessionManagement(sessionManagement ->
		  sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));     
		 
		
		http.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class);
		http.addFilterBefore(new JWTValidateFilter(), BasicAuthenticationFilter.class);
		return http.build();
	}
	@Bean
    public CorsFilter corsFilter()  {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200"); // this allows all origin
        config.addAllowedOrigin("http://localhost:8444/actuator"); //Testing purpose
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
