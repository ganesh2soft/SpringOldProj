package com.villi.ems33jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.villi.ems33jwt.entity.Ems33Joinee;
import com.villi.ems33jwt.repo.Ems33Repo;

@Service
public class Ems33Service {
	@Autowired
	Ems33Repo joineerepo;

	public Ems33Service() {
		super();
	}

	public Ems33Joinee saveJoinee(Ems33Joinee joinee) {
		return joineerepo.save(joinee);
	}

	public void deleteJoinee(Long joineeId) {
		joineerepo.deleteById(joineeId);
	}

	public List<Ems33Joinee> getAllEmployees() {

		return joineerepo.findAll();
	}

	public Ems33Joinee updateJoinee(Long joineeId, Ems33Joinee empl) {
		Ems33Joinee emp = joineerepo.findById(joineeId).get();

		emp.setJoineeName(empl.getJoineeName());
		emp.setDept(empl.getDept());
		emp.setRoles(empl.getRoles());
		return joineerepo.save(emp);
	}

	public Ems33Joinee findJoineeemail(String email) {

		return joineerepo.findJoineeByJoineeemail(email);
	}
	
	

}