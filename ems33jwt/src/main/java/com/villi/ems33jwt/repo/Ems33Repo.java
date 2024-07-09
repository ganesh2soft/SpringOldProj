package com.villi.ems33jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.villi.ems33jwt.entity.Ems33Joinee;

public interface Ems33Repo extends JpaRepository<Ems33Joinee, Long> {
	public Ems33Joinee findJoineeByJoineeemail(String email);
}
