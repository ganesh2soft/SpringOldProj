package com.koratur.travelapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koratur.travelapp.entity.TRForeignTour;
import com.koratur.travelapp.entity.TRTraveller;

@Repository
public interface TRforeignRepo extends JpaRepository<TRForeignTour, Long>{
//public TRTraveller  
}
