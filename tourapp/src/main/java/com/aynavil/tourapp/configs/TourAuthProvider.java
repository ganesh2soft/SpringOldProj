package com.aynavil.tourapp.configs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.aynavil.tourapp.entity.Customer;
import com.aynavil.tourapp.repo.CustomerRepo;

@Component
public class TourAuthProvider implements AuthenticationProvider {
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();

		Customer customer = customerRepo.findCustomerByCustemail(username);
		/*
		 * @Column(nullable = false,unique=true) private String customer;
		 */
		System.out.println("Found Customer object in TourGo APP" + customer);
		if (customer == null) {
			throw new StackOverflowError("No user got registered");
		} else if (pwd.equals(customer.getCustpwd())) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(customer.getRoles()));
			return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
		} else {
			System.out.println("I am a bad credentails");
			throw new StackOverflowError("Invalid Password");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
