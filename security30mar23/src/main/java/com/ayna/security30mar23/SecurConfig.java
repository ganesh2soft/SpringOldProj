package com.ayna.security30mar23;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurConfig {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		  .requestMatchers("/parent/**").permitAll()
		  .anyRequest().authenticated()
          .and()
          .httpBasic();
	//	http.csrf().disable();
        return http.build();
    }
}
