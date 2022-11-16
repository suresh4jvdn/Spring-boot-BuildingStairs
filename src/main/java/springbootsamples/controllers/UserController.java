package springbootsamples.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootsamples.entitie.User;
import springbootsamples.services.UserService;

@RestController
//@RequestMapping("first")
public class UserController {

	@Autowired
	private UserService userservice;

	@RequestMapping("userdata")
	public String getUser() {

		return "springboot-buildingStairs";
	}

	@PostMapping("/SaveAllUsers")
	public User saveusers(@RequestBody User user) {

		return userservice.creatUser(user);
	}

	@GetMapping("getallusers")
	public List<User> getusers() {
		// get all user details

		return userservice.getAllUsers();
	}

	// getuserbyId
	@GetMapping("/getuserbyid/{id}")
	public Optional<User> getUserByIds(@PathVariable("id") long id) {

		return userservice.getUserById(id);
	}

	// UpdateuserbyId
	@PutMapping("/updateuserbyid/{id}")
	public User updateUserByIds(@RequestBody User user, @PathVariable("id") long id) {

		return userservice.upDateUserById(id, user);
	}

	// DeleteuserbyId
	@DeleteMapping("/deleteuserbyid/{id}")
	public void deleteUserById(@PathVariable("id") long id) {

		userservice.deleteUserById(id);
	}

	// getuserbyUserName
	@GetMapping("/getUserByUserName/{username}")
	public User getUserByUserNames(@PathVariable("username") String username) {

		return userservice.getUserByusername(username);
	}

}
