package com.tcl.firstspringboot.config;

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

import com.tcl.firstspringboot.entity.ArtUser;
import com.tcl.firstspringboot.repository.ArtUserRepository;

@Component
public class ArticleAuthProvider implements AuthenticationProvider {

	@Autowired
	private ArtUserRepository artUserRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String un = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		ArtUser artuser = artUserRepository.findByUsername(un);

		System.out.println("Found user object" + artuser);
		if (artuser == null) {
			throw new StackOverflowError("No user got registered");
		} else if (pwd.equals(artuser.getPassword())) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(artuser.getRoles()));
			return new UsernamePasswordAuthenticationToken(un, pwd, authorities);
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
