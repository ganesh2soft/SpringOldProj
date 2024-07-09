package com.koratur.travelapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.koratur.travelapp.dto.TravelTourDto;
import com.koratur.travelapp.entity.TRTraveller;

@Repository
public interface TRtravRepo extends JpaRepository<TRTraveller, Long> {
	public TRTraveller findByTravellerid(Long travelcode);
	public TRTraveller findTravellerByTravellername(String travname);
	
//	@Query("select new tr.travellername,tr.travellerid, lt.location from TRTraveller tr \r\n"
//			+ "inner join TRLocalTour lt on tr.travellerid=lt.travellercode")
//
//	List<TravelTourDto> fetchQueryjoin();

}
