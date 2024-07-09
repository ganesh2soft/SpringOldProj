package com.aynavil.tourapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aynavil.tourapp.entity.Booking;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Long>{
//public TRTraveller  
}
