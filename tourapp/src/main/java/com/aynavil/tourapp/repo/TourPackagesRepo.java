package com.aynavil.tourapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aynavil.tourapp.entity.TourPackages;



@Repository
public interface TourPackagesRepo extends JpaRepository<TourPackages, Long>{
	
//	public TRLocalTour saveLocalTour(TRLocalTour tRLocalTour);

}
