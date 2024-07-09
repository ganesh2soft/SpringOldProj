package com.deeps.sprbootauthdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deeps.sprbootauthdemo.model.Users;
import com.deeps.sprbootauthdemo.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUserName(username);
		CustomUserDetails cuserDetails =null; 
		if(user != null) {
			cuserDetails = new CustomUserDetails();
			cuserDetails.setUser(user);
		}else {
			throw new UsernameNotFoundException("User "+ username + " Doesn't Exist");
		}
		return cuserDetails;
	}

}
