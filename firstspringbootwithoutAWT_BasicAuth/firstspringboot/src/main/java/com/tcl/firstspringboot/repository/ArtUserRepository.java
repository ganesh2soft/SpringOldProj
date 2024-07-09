package com.tcl.firstspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcl.firstspringboot.entity.ArtUser;
@Repository
public interface ArtUserRepository extends JpaRepository<ArtUser, Long> {
	public ArtUser findByUsername(String username);
}
