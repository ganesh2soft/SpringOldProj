package com.villi.ems33jwt.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.villi.ems33jwt.entity.Ems33Joinee;
import com.villi.ems33jwt.repo.Ems33Repo;

//@Component
public class Ems33JoineeAuthProvider implements AuthenticationProvider {

	@Autowired
	PasswordEncoder pwdencoder1; 

	@Autowired

	private Ems33Repo repoobj;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// Below 2 lines are getting User inputs at login page
	//	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	//	String username = auth.getName();
	//	Object credentials = auth.getCredentials();
		
		
String username = authentication.getName();
//Object credentials = authentication.getCredentials().toString();
		String pwd = authentication.getCredentials().toString();
		System.out.println("77777777777777777 777777777777777"+pwd);
		System.out.println("USername's Email ID refered as username :-----------" + username);
System.out.println("Supplied password "+pwd);
		System.out.println("**********************Hello*********" + repoobj.findJoineeByJoineeemail(username));
		Ems33Joinee joineeobj = repoobj.findJoineeByJoineeemail(username);
System.out.println("From DB"+joineeobj.getJoineepassword());
String encryptedPwd = pwdencoder1.encode(pwd);
System.out.println("Supplied password after encrytion"+encryptedPwd);
		System.out.println(" Ganesh just printing" + joineeobj);
		if (joineeobj == null) {
			// throw new BadCredentialsException("No user registered with this details");
			throw new StackOverflowError("No user got registered");
		} else if (pwdencoder1.matches(pwd, joineeobj.getJoineepassword())) {
			System.out.println(" Password true just printing" + joineeobj);
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(joineeobj.getRoles()));
			System.out.println("88888888888888888888888888888888888888888888888"+pwd);
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
