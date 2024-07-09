package com.tcl.firstspringboot.service;

import java.util.List;
import java.util.Optional;

import com.tcl.firstspringboot.entity.ArtUser;

public interface UserService {

	public ArtUser addUser(ArtUser artuser);
	public List<ArtUser> listAllUser();
	public Optional<ArtUser> findByUserId(Long id);
}
