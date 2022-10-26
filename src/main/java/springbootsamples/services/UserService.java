package springbootsamples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootsamples.Repo.UserRepo;
import springbootsamples.entitie.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userrepo;
	
	//saveAllUsers
	public User creatUser(User user){
		
		return userrepo.save(user);
	}
	
	//getAllUsers
	public List<User> getAllUsers() {
		
		return userrepo.findAll();
	}
		
		
	

}
