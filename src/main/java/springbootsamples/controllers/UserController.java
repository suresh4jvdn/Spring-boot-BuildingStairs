package springbootsamples.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springbootsamples.entitie.User;
import springbootsamples.services.UserService;

@RestController
@RequestMapping("enter")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	@RequestMapping("userdata")
	public String getUser() {
		
		return "springboot-buildings";
	}
	
	@PostMapping("saveusers")
	public User saveusers(@RequestBody User user) {
		
		return userservice.creatUser(user);
	}
	
	@GetMapping("getallusers")
	public List<User> getusers() {
		
		return userservice.getAllUsers();
	}
	
	

}
