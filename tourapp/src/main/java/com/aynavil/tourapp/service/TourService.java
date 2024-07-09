package com.aynavil.tourapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aynavil.tourapp.entity.Customer;
import com.aynavil.tourapp.repo.CustomerRepo;
import jakarta.persistence.EntityManager;

@Service
public class TourService {
	@Autowired
	EntityManager em;
	@Autowired
	private CustomerRepo customerRepo;
	
	
	public List<Customer> fnServicelistcust() {

		return customerRepo.findAll();
	}
	
	public Customer fnServiceregsister(Customer customer) {
		return customerRepo.save(customer);
	}
	
	
	
	
	/*
	
	@Autowired
	private TRlocalRepo trlocalrepo;
	@Autowired
	private TRforeignRepo trforeignrepo;

	

	

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

*/
}
