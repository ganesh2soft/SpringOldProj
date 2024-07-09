package com.villi.ems33jwt.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.villi.ems33jwt.filters.CsrfCookieFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
@SuppressWarnings("unused")
public class Ems33SecurityConfig {

	@Autowired
	Ems33JoineeAuthProvider ap;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		CsrfTokenRequestAttributeHandler requestHandler=new CsrfTokenRequestAttributeHandler();
		requestHandler.setCsrfRequestAttributeName("_csrf");
		
		
//		http.securityContext(securityContext -> securityContext.
//			      securityContextRepository(new HttpSessionSecurityContextRepository())
//			);
		http
		.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
		//securityContext().requireExplicitSave(false).and()
		
		
		http.authorizeHttpRequests().requestMatchers("/ems/").permitAll()
		.requestMatchers("/ems/customloginpagectrlr")
				.permitAll().requestMatchers("/ems/registerctrlr").permitAll().requestMatchers("/ems/addjoinee/**")
				.permitAll().requestMatchers("/ems/errorctrlr").permitAll()
			
				.requestMatchers("/payroll/").permitAll()	
				.requestMatchers("/payroll/loginhdlr/**").permitAll()	
				.requestMatchers("/payroll/addemployeehdlr").permitAll()
				.requestMatchers("/payroll/noticeshdlr").permitAll()
				.requestMatchers("/payroll/mydashboardhdlr").authenticated()
				.requestMatchers("/payroll/allemployeeshdlr").authenticated()
				.requestMatchers("/payroll/deleteempIdhdlr/**").authenticated()
				.requestMatchers("/payroll/updateemphdlr/**").authenticated()
				.anyRequest().permitAll().and()

				
				.formLogin(form -> form.loginPage("/ems/customloginpagectrlr")

						.defaultSuccessUrl("/ems/profilepagectrlr", true).permitAll()

				).httpBasic();
				
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
		http.logout().logoutUrl("/ems/logoutctrlr").logoutSuccessUrl("/ems/logoutsuccessctrlr");
http.cors();
		return http.build();

	}
	@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200"); // this allows all origin
        config.addAllowedHeader("*"); // this allows all headers
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
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
