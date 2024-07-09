package com.tcl.firstspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcl.firstspringboot.entity.ArtUser;
import com.tcl.firstspringboot.repository.ArtUserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	ArtUserRepository artUserRepository;
	
	@Override
	public ArtUser addUser(ArtUser artuser) {
		return artUserRepository.save(artuser);
	}

	@Override
	public List<ArtUser> listAllUser() {

		return artUserRepository.findAll();
	}

	@Override
	public Optional<ArtUser> findByUserId(Long id) {

		return artUserRepository.findById(id);
	}

}
