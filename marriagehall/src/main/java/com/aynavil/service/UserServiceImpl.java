package com.aynavil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aynavil.dao.Userdao;
import com.aynavil.entity.Userdetails;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	public Userdao userdao;


	public void createUser(Userdetails userdetails) {
		 userdao.createUser(userdetails);
		
		
	}

}
