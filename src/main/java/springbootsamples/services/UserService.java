package springbootsamples.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import springbootsamples.ExceptionHandling.UserExistsException;
import springbootsamples.ExceptionHandling.UserNotFoundException;
import springbootsamples.Repo.UserRepository;
import springbootsamples.entitie.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepository;

	// saveAllUsers
	public User creatUser(User user)throws UserExistsException{
		
		User userexist= userrepository.findByUserName(user.getUsername());
		
		if(userexist!=null) {
			throw new UserExistsException("user already exist in repository");
		}

		return userrepository.save(user);  
	}

	// getAllUsers
	public List<User> getAllUsers() {

		return userrepository.findAll();
	}

	// GetUserById
	public Optional<User> getUserById(long id) throws UserNotFoundException {

		Optional<User> userid = userrepository.findById(id);

		if (!userid.isPresent()) {
			throw new UserNotFoundException("user not found in the repository");
		}

		return userid;
	}

	// UpdateUserById
	public User upDateUserById(long id, User user) throws UserNotFoundException {

		Optional<User> optionaluser = userrepository.findById(id);

		if (!optionaluser.isPresent()) {
			throw new UserNotFoundException("user not found in the repository, So please provide the correct user id");
		}

		user.setId(id);

		return userrepository.save(user);
	}

	/*
	 * // DeleteUserById public void deleteUserById(long id) {
	 * 
	 * // userrepo.deleteById(id); // we can give directly if we know (if we don't
	 * know // that id available/unavailable by conditions we can run.
	 * 
	 * if (userrepository.findById(id).isPresent()) {
	 * 
	 * userrepository.deleteById(id); } else { System.out.println("There is no ID");
	 * } }
	 */
	
	

	// DeleteUserByIdWithExceptionhandling Direct from service
	public void deleteUserById(long id) {

		Optional<User> deleteuser = userrepository.findById(id);

		if (!deleteuser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"user not found in the repository, So please provide the correct user id for the deletion");
		}

		userrepository.deleteById(id);
	}
	

	// GetUserByUserName
	public User getUserByusername(String username) {

		return userrepository.findByUserName(username);
	}

}
