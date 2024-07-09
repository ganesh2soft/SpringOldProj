package com.aynavil.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.stereotype.Repository;

import com.aynavil.entity.Userdetails;

@Repository

public class UserdaoImpl implements Userdao{
	
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	public void createUser(Userdetails userdetails) {
		getSession().saveOrUpdate(userdetails);
		System.out.println("User Details Added successfully...");
	
		
		
	}
	

}
