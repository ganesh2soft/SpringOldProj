package com.ayna.ems22.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ayna.ems22.entity.Joinee;
import com.ayna.ems22.service.Ems22JoineeRegSrv;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/joinee")
public class Ems22Controller {
	@Autowired
	Ems22JoineeRegSrv joineeService;
	Joinee joinee;

	@GetMapping("/")
	public String welcome() {
		return "index";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}
	@PostMapping(value="/addjoinee")
	public ModelAndView signup(@RequestParam("txtjname") String joineename,
			@RequestParam("txtjemail") String joineeemail, @RequestParam("txtjpass") String joineepassword,
			@RequestParam("txtjgender") String joineegender) {
		System.out.println("joineeemail  "+ joineeemail);		
		joinee = new Joinee();
		joinee.setJoineeName(joineename);
		joinee.setJoineeemail(joineeemail);
		joinee.setJoineepassword(joineepassword);
		joinee.setJoineegender(joineegender);
		joineeService.saveJoinee(joinee);
		return new ModelAndView("index");
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam("txtjemail") String email, @RequestParam("txtjpass") String pass) {
		Joinee empl = joineeService.findJoineeemail(email);

		if (empl == null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("NOTIFICATION", "Employee DOESN'T Exist");
			return mv;

		} else {
			return allEmployees();
		}
	}
	
	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public ModelAndView signin() {
		return new ModelAndView("login");
	}
	
	public ModelAndView allEmployees() {
		List<Joinee> empList = joineeService.getAllEmployees();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("allemp", empList);
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	  public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response){
//	        
//		 System.out.println("first line logout works");
//	      HttpSession session = request.getSession(false);
//	      String username = (String) session.getAttribute("joineename");
//	      System.out.println(session.toString());
//	      SecurityContextHolder.clearContext();
//
//	      session = request.getSession(false);
//	     
//	      if(session != null) {
//	          session.invalidate();
//	      }
//System.out.println(session.toString());
//	      for(Cookie cookie : request.getCookies()) {
//	          cookie.setMaxAge(0);
//	      }
//
//	      return "success";
//	  }
}
