package com.aynavil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aynavil.dao.Bookingdao;
import com.aynavil.entity.Booking;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	@Autowired
	public Bookingdao bookingdao;


	@Override
	public void Bookhall(Booking booking) {
		bookingdao.Bookhall(booking);
	
		
	}

}
