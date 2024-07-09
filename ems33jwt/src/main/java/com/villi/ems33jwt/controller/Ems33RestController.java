package com.villi.ems33jwt.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.villi.ems33jwt.configuration.Ems33JoineeAuthProvider;
import com.villi.ems33jwt.entity.Ems33Joinee;
import com.villi.ems33jwt.repo.Ems33Repo;
import com.villi.ems33jwt.service.Ems33Service;

@RestController
@RequestMapping("/payroll")
/*
 * @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*",
 * 
 * methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
 * RequestMethod.DELETE })
 */

//@CrossOrigin(origins = "http://localhost:4200/",exposedHeaders = {"Access-Control-Allow-Origin"})
public class Ems33RestController {
	@Autowired
	Ems33Service ems33Service;
	@Autowired
	Ems33Repo joineerepo;
    @Autowired
	PasswordEncoder pwdencoder1;
   // HttpSessionSecurityContextRepository hscr=new HttpSessionSecurityContextRepository();

	@GetMapping("/")
	public String helloAppln() {
		return "Hi Welcome to Ayna Technologies";
	}

	@PostMapping("/addemployeehdlr")
	public Ems33Joinee saveJoin(@RequestBody Ems33Joinee ems33Joinee) {
		/*
		 * Below Hard coding is important here , roles is getting default
		 * 'productionuser' Otherwise value 'null' has been set which stops working of
		 * authenticate() in JoineeAuthProvider class Also for dept.
		 */
		SecurityContextHolder.getContext().setAuthentication(null);

		ems33Joinee.setJoineeName(ems33Joinee.getJoineeName());
		ems33Joinee.setJoineeemail(ems33Joinee.getJoineeemail());
		
		String encryptedPwd = pwdencoder1.encode(ems33Joinee.getJoineepassword());
		System.out.println("At time of adding"+encryptedPwd);
		ems33Joinee.setJoineepassword(encryptedPwd);
		ems33Joinee.setJoineegender(ems33Joinee.getJoineegender());
		ems33Joinee.setRoles("HRSTAFF");
		ems33Joinee.setDept("newdept");
		
		return ems33Service.saveJoinee(ems33Joinee);
	}

//	@PreAuthorize("hasAuthority('HRSTAFF')")
	@GetMapping("/allemployeeshdlr")
	public List<Ems33Joinee> fetchAllEmployees() {
		return ems33Service.getAllEmployees();
	}

	@GetMapping("/empbyemailhdlr/{email}")
	public Ems33Joinee fetchEmployeeByEmail(@PathVariable("email") String email) {

		return ems33Service.findJoineeemail(email);
	}

	@DeleteMapping("/deleteempIdhdlr/{eid}")
	public void deleteEmployeeById(@PathVariable("eid") Long eid) {
		ems33Service.deleteJoinee(eid);
		System.out.println("Employee or Joinee  " + eid + "deleted Successfully");
	}

	@PutMapping("/updateemphdlr/{eid}")
	public Ems33Joinee updateEmployee(@RequestBody Ems33Joinee ems33Joinee) {
		return ems33Service.updateJoinee(ems33Joinee.getJoineeId(), ems33Joinee);

	}

	@GetMapping("/mydashboardhdlr")
	public String dashrest() {
		return "You are inside Dashboard component";
	}
	
	@GetMapping("/loginhdlr")
	public ResponseEntity<Ems33Joinee> loginrest(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
		Ems33Joinee welcomeUser = joineerepo.findJoineeByJoineeemail(auth.getName());
		System.out.println("Who is Welcome " + welcomeUser);
		
		return ResponseEntity.ok(welcomeUser);

	}

	/*
	 * Ems33Joinee joineeobj = joineerepo.findJoineeByJoineeemail(username);
	 * 
	 * if (joineeobj == null) { // throw new
	 * BadCredentialsException("No user registered with this details"); throw new
	 * StackOverflowError("No user got registered"); } else if
	 * (pwdencoder1.matches(password, joineeobj.getJoineepassword())) {
	 * System.out.println(" Password true just printing" + joineeobj);
	 * List<GrantedAuthority> authorities = new ArrayList<>(); authorities.add(new
	 * SimpleGrantedAuthority(joineeobj.getRoles()));
	 * 
	 * new UsernamePasswordAuthenticationToken(username, password, authorities);
	 * return "yes"; }else{System.out.println("I am a bad credentails"); throw new
	 * StackOverflowError("Invalid Password"); }
	 * 
	 * }
	 * 
	 * /* Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication(); String username =
	 * auth.getName(); String pwd = auth.getCredentials().toString();
	 * 
	 * 
	 * 
	 * String recusername=ems33Joinee.getJoineeName();
	 * 
	 * 
	 * // Object credentials = auth.getCredentials();
	 * 
	 * 
	 * System.out.println("**********************Hello*********" +
	 * repoobj.findJoineeByJoineeemail(username)); Ems33Joinee joineeobj =
	 * repoobj.findJoineeByJoineeemail(username);
	 * 
	 * System.out.println(" Ganesh just printing" + joineeobj); if (joineeobj ==
	 * null) { // throw new
	 * BadCredentialsException("No user registered with this details"); throw new
	 * StackOverflowError("No user got registered"); } else if
	 * (pwdencoder1.matches(pwd, joineeobj.getJoineepassword())) {
	 * System.out.println(" Password true just printing" + joineeobj);
	 * List<GrantedAuthority> authorities = new ArrayList<>(); authorities.add(new
	 * SimpleGrantedAuthority(joineeobj.getRoles()));
	 * 
	 * return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
	 * 
	 * 
	 * } else { System.out.println("I am a bad credentails"); throw new
	 * StackOverflowError("Invalid Password");
	 * 
	 * }
	 * 
	 * String emailems33Joinee.getJoineeemail();
	 * 
	 * Ems33JoineeAuthProvider jap=new Ems33JoineeAuthProvider(); //
	 * jap.authenticate(authentication);
	 * System.out.println("sdfjsdkljflsk;jfl;ksjdf;lksjdflksadjfsdklj");
	 * Authentication authentication1 =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * System.out.println("Beauty"+authentication1); Ems33Joinee
	 * empa=ems33Service.findJoineeemail(authentication1.getName());
	 * 
	 * 
	 * 
	 * return empa; }
	 */
	static List<String> list() {
		return new ArrayList<>() {
			{
				add("EPFO is one of the World's largest Social Security Organisations");
				add("National Pension System (NPS), Regulated By PFRDA, is an important milestone in Labour welfare");
				add("The promulgation of Employees' State Insurance Act, 1948(ESI Act), by the Parliament was the first major legislation on social Security for workers in independent India");
			}
		};
	}

	@GetMapping("/noticeshdlr")
	public List<String> getList() {
		return list();
	}

}
