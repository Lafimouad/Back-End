package ConsomiTounsi.repository;

import ConsomiTounsi.entities.User;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional 
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	User findByUsernameUser(String username);
	public List<User> findByFirstNameUser(String firstname); 
	public List<User> findByLastNameUser(String lastname);
	
	@Query("SELECT u FROM User u WHERE u.firstNameUser= :fn AND u.lastNameUser = :ln" )
	List<User> RetiveUserByFirstAndLastNameJPQL(@Param("fn") String fn , @Param("ln") String ln);
	
	
}
