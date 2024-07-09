package com.deeps.sprbootauthdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig  {

	@Autowired
	private UserDetailsService userDetailsService;

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(encodePassword());
//	}

//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/rest/**").authenticated().anyRequest().permitAll().and()
//				.authorizeRequests().antMatchers("/admin/**").authenticated().anyRequest().hasAnyRole("ADMIN").and()
//				.formLogin().permitAll();
//	}
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/users/**", "/settings/**").hasAuthority("ADMIN")
          //      .hasAnyAuthority("Admin", "Editor", "Salesperson")
          //   .hasAnyAuthority("ADMIN", "User")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                    .usernameParameter("email")
                    .permitAll()
                .and()
                .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
                .and()
                .logout().permitAll();
 
        http.headers().frameOptions().sameOrigin();
 
        return http.build();
    }
 
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable()
//		.exceptionHandling().authenticationEntryPoint(authEntryPointJWT).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//				.antMatchers("/api/auth/**").permitAll().antMatchers("/test/**").permitAll().anyRequest()
//				.authenticated();
//
//		http.authenticationProvider((authenticationProvider()));
//		http.addFilterBefore(authentificationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//		return http.build();
//	}
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER")
//				.and().withUser("admin").password("{noop}password").roles("ADMIN");
//	}

	public BCryptPasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}
}
