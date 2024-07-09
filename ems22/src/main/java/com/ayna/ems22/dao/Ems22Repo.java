package com.ayna.ems22.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ayna.ems22.entity.Joinee;



public interface Ems22Repo extends JpaRepository<Joinee, Long>{
	public Joinee findJoineeByJoineeemail(String email);
}
	