package com.aynavil.tourapp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aynavil.tourapp.constants.SecurityConstants;
import com.aynavil.tourapp.entity.Customer;
import com.aynavil.tourapp.entity.EndUser;
import com.aynavil.tourapp.repo.CustomerRepo;
import com.aynavil.tourapp.service.TourService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class TourRestController {
	@Autowired
	HttpServletResponse httpServletResponse;
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	TourService tourService;
	@Autowired
	EndUser enduser;

	@GetMapping("/welcome")
	public ResponseEntity<String> helloAppln() {
		String responseMessage = "TourGo Backend welcomes you! We are Connected right now";
		return ResponseEntity.ok(responseMessage);
	}

	@GetMapping("/login")
	
	public ResponseEntity<Customer> processRequest() {
		

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Customer welcomeUser = customerRepo.findCustomerByCustemail(auth.getName());
		System.out.println("Response body user details=========" + welcomeUser);
		try {
            // Introduce a 3-second (3000 milliseconds) delay
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
		
		
		String hr=httpServletResponse.getHeader(SecurityConstants.JWT_HEADER);
		System.out.println(hr);
		
		 HttpHeaders headers = new HttpHeaders();
	        headers.add(SecurityConstants.JWT_HEADER, "hr");
	        ResponseEntity<Customer> responseEntity = new ResponseEntity<>(welcomeUser, headers, HttpStatus.OK);

	        return responseEntity;
	
	}
	
	@GetMapping("/myoffers")
	public ResponseEntity<String> myoffers(){
		String couponCode = "HONEYMOONAAA509";
		return ResponseEntity.ok(couponCode);
	}
	

	@PostMapping("/signup")
	public ResponseEntity<Customer> signupCustomer(@RequestBody Customer customer) {
		Customer newcustomer = tourService.fnServiceregsister(customer);
//		 You might want to save the customer to a database and return the saved customer
		return ResponseEntity.status(HttpStatus.CREATED).body(newcustomer);
	}

	@GetMapping("/adminlogin")
	public String adminlogin() {
		return "Admin Login";
	}

	
//	Done by Admin login only
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/listcustomers")
	public List<Customer> listcust() {
		return tourService.fnServicelistcust();
	}

	
//	 * Done by Admin login only
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deletecustomers")
	public String deletecust() {
		return "Delete customers";
	}

	// --------- Done by Admin login only
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/updatecustomers")
	public String editcust() {
		return "Edit customers";
	}
}
