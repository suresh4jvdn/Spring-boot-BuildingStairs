package springbootsamples.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springbootsamples.entitie.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	

}
