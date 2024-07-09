package com.koratur.travelapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koratur.travelapp.dto.TravelTourDto;
import com.koratur.travelapp.entity.TRForeignTour;
import com.koratur.travelapp.entity.TRLocalTour;
import com.koratur.travelapp.entity.TRTraveller;
import com.koratur.travelapp.repo.TRtravRepo;
import com.koratur.travelapp.service.TRService;

@RestController
public class TRRestController {
	@Autowired
	TRService serviceobj;
	@Autowired
	TRtravRepo tRtravRepo;

	@GetMapping("/welcome")
	public String helloAppln() {
		return "Hi Welcome to Travel Request APP";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/addtraveller")
	public TRTraveller fnaddtraveller(@RequestBody TRTraveller tRTraveller) {

		return serviceobj.fnServiceadd(tRTraveller);

	}
//	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/listtravellers")
	public List<TRTraveller> fnlistUsers() {
		return serviceobj.fnServicelistuser();
	}

	@GetMapping("/login")
	public ResponseEntity<TRTraveller> loginrest(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
        TRTraveller tRTraveller = tRtravRepo.findTravellerByTravellername(auth.getName());
        System.out.println("After Login_____________________________________________"
        		+ "send back to Angular or postman as response_____________________________________"+tRTraveller);
		return ResponseEntity.ok(tRTraveller);
	}
	
	
	@PreAuthorize("hasAuthority('DOMESTICCUSTOMER')")
	@PostMapping("/requestlocaltour")
	public TRLocalTour fnreqlocal  (@RequestBody TRLocalTour tRLocalTour) throws Exception {

		return serviceobj.fnServicerl(tRLocalTour);
	}

	@PreAuthorize("hasAuthority('FOREIGNCUSTOMER')")
	@PostMapping("/requestforeigntour")
	public TRForeignTour fnreqforeign(@RequestBody TRForeignTour tRForeignTour) {
		return serviceobj.fnServicerf(tRForeignTour);
	}

	
	
	
	
	@GetMapping("/fetchdetailsbyjoins/{travellerid}")
	public ResponseEntity<List<TravelTourDto>> fetchdetails(@PathVariable(value="travellerid") Long id)
	
	{
		System.out.println("Traffic hitting the controller__________________");
		return new ResponseEntity<List<TravelTourDto>>(serviceobj.fnServicefetchjoins(id), HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/listtour")
	public String fnlistTour() {
		return "Hi Welcome to Travel Request APP !!! List of Tour Packages";
	}

//@PostMapping("/error")
	public String fnerror() {
		return "Error found in APP!! Team is working on it";
	}
}