package com.aynavil.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aynavil.entity.Booking;

@Repository
public class BookingdaoImpl implements Bookingdao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void Bookhall(Booking booking) {
        getSession().saveOrUpdate(booking);
        System.out.println("Booked successfully...");
    }
}
