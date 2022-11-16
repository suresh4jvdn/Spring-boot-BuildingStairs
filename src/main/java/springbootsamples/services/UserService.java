package springbootsamples.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootsamples.Repo.UserRepository;
import springbootsamples.entitie.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepository;

	// saveAllUsers
	public User creatUser(User user) {

		return userrepository.save(user);
	}

	// getAllUsers
	public List<User> getAllUsers() {

		return userrepository.findAll();
	}

	// GetUserById
	public Optional<User> getUserById(long id) {

		Optional<User> userid = userrepository.findById(id);

		return userid;
	}

	// UpdateUserById
	public User upDateUserById(long id, User user) {
		user.setId(id);

		return userrepository.save(user);
	}

	// DeleteUserById
	public void deleteUserById(long id) {

		// userrepo.deleteById(id); // we can give directly if we know (if we don't know
		// that id available/unavailable by conditions we can run.

		if (userrepository.findById(id).isPresent()) {

			userrepository.deleteById(id);
		} else {
			System.out.println("There is no ID");
		}
	}

	// GetUserByUserName
	public User getUserByusername(String username) {

		return userrepository.findByUserName(username);
	}

	
}
