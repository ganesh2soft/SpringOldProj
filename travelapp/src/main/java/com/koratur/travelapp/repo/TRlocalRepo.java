package com.koratur.travelapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koratur.travelapp.entity.TRLocalTour;


@Repository
public interface TRlocalRepo extends JpaRepository<TRLocalTour, Long>{
	
//	public TRLocalTour saveLocalTour(TRLocalTour tRLocalTour);

}
