package com.koratur.travelapp.config;

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

import com.koratur.travelapp.entity.TRTraveller;
import com.koratur.travelapp.repo.TRtravRepo;

import jakarta.persistence.Column;

@Component
public class TRAuthProvider implements AuthenticationProvider {
	@Autowired
	private TRtravRepo tRtravRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		TRTraveller tRTraveller = tRtravRepo.findTravellerByTravellername(username);
		/*
		 * @Column(nullable = false,unique=true)
			private String travellername;
		 */
		System.out.println("Found Travel object"+tRTraveller);
		if (tRTraveller == null) {
			throw new StackOverflowError("No user got registered");
		} else if (pwd.equals(tRTraveller.getTravellerpwd()) ) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(tRTraveller.getRoles()));
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
