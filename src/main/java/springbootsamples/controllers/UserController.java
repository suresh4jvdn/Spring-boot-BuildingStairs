package springbootsamples.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import springbootsamples.ExceptionHandling.UserExistsException;
import springbootsamples.ExceptionHandling.UserNotFoundException;
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
	public ResponseEntity<Void> saveusers(@RequestBody User user, UriComponentsBuilder builder) throws UserExistsException {

		try {
			 userservice.creatUser(user);
			 HttpHeaders headers=new HttpHeaders();
			 headers.setLocation(builder.path("/SaveAllUsers/{id}").buildAndExpand(user.getId()).toUri());
			 return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		} catch (UserExistsException e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	
	@GetMapping("getallusers")
	public List<User> getusers() {
		// get all user details

		return userservice.getAllUsers();
	}

	// getuserbyId
	@GetMapping("/getuserbyid/{id}")
	public Optional<User> getUserByIds(@PathVariable("id") long id) throws UserNotFoundException {

		try {
			return userservice.getUserById(id);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	// UpdateuserbyId
	@PutMapping("/updateuserbyid/{id}")
	public User updateUserByIds(@RequestBody User user, @PathVariable("id") long id) throws UserNotFoundException {

		try {
			return userservice.upDateUserById(id, user);
		} catch (UserNotFoundException e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

		}
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
