package com.villi.ems33jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.villi.ems33jwt.entity.Ems33Joinee;
import com.villi.ems33jwt.service.Ems33Service;

@Controller
@RequestMapping("/ems")
public class Ems33Controller {
	@Autowired
	Ems33Service joineeService;
@Autowired
PasswordEncoder pwdencoder1;
	@GetMapping("/")
	public String welcome() {
		return "indexpage";
	}

	/*
	 * Below two /customloginpagectrlr and /logoutsuccessctrlr are login and logout
	 * purposes respectively
	 */
	@GetMapping("/customloginpagectrlr")
	public String getin() {
		return "customloginpage";
	}

	@GetMapping("/logoutsuccessctrlr")
	public String loggout() {
		System.out.println("You are inside logout ctrlr -----------------------------");
		return "logoutpage";
	}

	/*
	 * Below two /registerctrlr and /addjoinee are User Signup and User Signup
	 * logics respectively
	 */

	@GetMapping("/registerctrlr")
	public ModelAndView register() {

		SecurityContextHolder.getContext().setAuthentication(null);
		return new ModelAndView("registerpage");
	}

	@PostMapping(value = "/addjoinee")
	public ModelAndView signup(@RequestParam("txtjname") String joineename,
			@RequestParam("txtjemail") String joineeemail, @RequestParam("txtjpass") String joineepassword,
			@RequestParam("txtjgender") String joineegender) {
		Ems33Joinee joinee = new Ems33Joinee();

		joinee.setJoineeName(joineename);
		joinee.setJoineeemail(joineeemail);
		String encryptedPwd = pwdencoder1.encode(joineepassword);
		joinee.setJoineepassword(encryptedPwd);
		joinee.setJoineegender(joineegender);
		/*
		 * Below Hard coding is important here , roles is getting default
		 * 'productionuser' Otherwise value 'null' has been set which stops working of
		 * authenticate() in JoineeAuthProvider class Also for dept.
		 */
		joinee.setRoles("HRSTAFF");
		joinee.setDept("newdept");
		joineeService.saveJoinee(joinee);
		return new ModelAndView("indexpage");
	}

	/*
	 * Below /profilepagectrlr is loading self's one profile once user logins in
	 */
	@GetMapping("/profilepagectrlr")
	public ModelAndView profileLoading() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println("Currently Logged in user's email is " + currentPrincipalName);
		Ems33Joinee empl = joineeService.findJoineeemail(currentPrincipalName);
		ModelAndView mv1 = new ModelAndView("profilepage");
		mv1.addObject("displayemp", empl);
		return mv1;
	}

	/*
	 * Below /hradminctrlr is loading for Admin purposes Admin is able to see all
	 * employee details
	 */

	@PreAuthorize("hasAnyAuthority('HRMANAGER','HRSTAFF')")
	@GetMapping("/hradminctrlr")
	public ModelAndView hrAdminee() {
		System.out.println("You are Admin ctrlr ______________________________________");
		List<Ems33Joinee> empList = joineeService.getAllEmployees();
		ModelAndView mv = new ModelAndView("emshomepage");
		mv.addObject("allemp", empList);
		return mv;
	}

	public ModelAndView allEmployees() {
		List<Ems33Joinee> empList = joineeService.getAllEmployees();
		ModelAndView mv = new ModelAndView("emshomepage");
		mv.addObject("allemp", empList);
		return mv;
	}
// ErrorController
	/*
	 * Below /hradminctrlr is loading for Admin purposes Admin is able to delete the
	 * employee based on Employee/Joinee ID
	 */
	@PreAuthorize("hasAuthority('HRMANAGER')")
	@GetMapping(value = "/deletectrlr")
	public ModelAndView delete(Ems33Joinee empl) {
		System.out.println("Flow is in delete controllr__________________________");
		joineeService.deleteJoinee(empl.getJoineeId());

		return allEmployees();
	}

	/*
	 * Below two /editctrlr and /updateempctrlr are Admin's update purpose.
	 * /editctrlr -- To bring update page to Admin /updateempctrlr----- Business
	 * logics for Employee record updation
	 */

	@GetMapping(value = "/editctrlr")
	@PreAuthorize("hasAuthority('HRSTAFF')")
	public ModelAndView edit(Ems33Joinee empl) {

		return new ModelAndView("hreditpage");
	}

	@GetMapping(value = "/updateempctrlr")
	public ModelAndView update(@ModelAttribute Ems33Joinee empl) {
		System.out.println("Flow is in EDITING controllr__________________________");
	//	Ems33Joinee emp = joineeService.updateJoinee(empl.getJoineeId(), empl);
		return allEmployees();
	}

	/*
	 * Below /noticesctrlr is loading for everyone (like index page)
	 * 
	 */
	@GetMapping("/noticesctrlr")
	public String notices() {
		return "noticespage";

	}
}
