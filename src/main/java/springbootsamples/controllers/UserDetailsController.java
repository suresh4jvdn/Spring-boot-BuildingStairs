package springbootsamples.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootsamples.entitie.UserDetails;

@RestController
public class UserDetailsController {
	
	@GetMapping("/hello")
	public String getHelloWorld() {
		
		return "welcome hello world";
	}
	
	@GetMapping("/userdetails")
	public UserDetails getUserDetails() {
		
		return new UserDetails("kille","suresh","kurnool");
	}

}
