package ConsomiTounsi.repository;

import ConsomiTounsi.entities.User;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User>  findByUsernameUser(String username);

	List<User> findByFirstNameUser(String firstname);
	List<User> findByLastNameUser(String lastname);
	
	@Query("SELECT u FROM User u WHERE u.firstNameUser= :fn AND u.lastNameUser = :ln" )
	List<User> RetiveUserByFirstAndLastNameJPQL(@Param("fn") String fn , @Param("ln") String ln);
	
	
}
