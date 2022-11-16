package springbootsamples.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springbootsamples.entitie.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value="select * from Users where username=:username1",nativeQuery = true)
  User findByUserName(@Param("username1")String username);
  
	/*
	 * @Query(
	 * value="SELECT * FROM ORGANIZATION WHERE id = :organizationId AND NAME LIKE %:organizationId% LIMIT 1 "
	 * , nativeQuery = true) Organization
	 * findFirstNameByNameLike(@Param("organizationId") Long
	 * organizationId, @Param("name") String name);
	 */


}
