package com.aynavil.tourapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aynavil.tourapp.entity.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
//	public Customer findCustomerByid(Long travelcode);
	public Customer findCustomerByCustname(String custom);
	public Customer findCustomerByCustemail(String customeremail);
	
	
//	@Query("select new tr.travellername,tr.travellerid, lt.location from TRTraveller tr \r\n"
//			+ "inner join TRLocalTour lt on tr.travellerid=lt.travellercode")
//
//	List<TravelTourDto> fetchQueryjoin();

}
