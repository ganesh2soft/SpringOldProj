package com.koratur.travelapp.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koratur.travelapp.dto.TravelTourDto;
import com.koratur.travelapp.entity.TRForeignTour;
import com.koratur.travelapp.entity.TRLocalTour;
import com.koratur.travelapp.entity.TRTraveller;
import com.koratur.travelapp.repo.TRforeignRepo;
import com.koratur.travelapp.repo.TRlocalRepo;
import com.koratur.travelapp.repo.TRtravRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.TypedQuery;

@Service
public class TRService {
	@Autowired
	EntityManager em;
	@Autowired
	private TRtravRepo trrepo;
	@Autowired
	private TRlocalRepo trlocalrepo;
	@Autowired
	private TRforeignRepo trforeignrepo;

	public TRTraveller fnServiceadd(TRTraveller travellerobj) {
		return trrepo.save(travellerobj);
	}

	public List<TRTraveller> fnServicelistuser() {

		return trrepo.findAll();
	}

	public TRLocalTour fnServicerl(TRLocalTour trLocalTour) {
		
		 TRTraveller tRTraveller = trLocalTour.getTrtourist();
	
	    trLocalTour.setTrtourist(tRTraveller);
		 return trlocalrepo.save(trLocalTour);
	      

	}

     public TRForeignTour fnServicerf(TRForeignTour trForeignTour) {
    	 TRTraveller tRTraveller = trForeignTour.getTrtourist();
    		
    	 trForeignTour.setTrtourist(tRTraveller);
 		 return trforeignrepo.save(trForeignTour);
}

public List<TravelTourDto> fnServicefetchjoins(Long idd) {
	
	
	
	
	System.out.println("Control landed successfuly in service "+idd);
	
	String sqlQuery = "select tr.travellername,tr.travellerid, lt.location from tbl_traveller tr "
			+ "inner join tbl_local lt on tr.travellerid=lt.travellercode where tr.travellerid=:idd";
	
	List<TravelTourDto> resultlist = em.createNativeQuery(sqlQuery,TravelTourDto.class)
			
			.setParameter("idd", idd)
			
			   	    .getResultList();
	
	return resultlist;
	
	
	
}


}
