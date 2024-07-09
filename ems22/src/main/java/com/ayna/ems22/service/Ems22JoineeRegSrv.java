package com.ayna.ems22.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayna.ems22.dao.Ems22Repo;
import com.ayna.ems22.entity.Joinee;





@Service
public class Ems22JoineeRegSrv {
	@Autowired
	Ems22Repo joineerepo;
	
	public Ems22JoineeRegSrv() {
		super();
	}
	
	public Joinee saveJoinee(Joinee joinee) {
		System.out.println("To save : " + joinee);
		return joineerepo.save(joinee);
	}


	public List<Joinee> getAllEmployees() {

		return joineerepo.findAll();
	}
	
	
	public Joinee findJoineeemail(String email) {

		return joineerepo.findJoineeByJoineeemail(email);
	}
}
