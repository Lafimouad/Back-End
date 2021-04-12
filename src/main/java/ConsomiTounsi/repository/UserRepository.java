package ConsomiTounsi.repository;

import ConsomiTounsi.entities.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	//@Query("SELECT u FROM USER u WHERE u.username_user =: username ")
	//User findByUsername_user (@Param("username")String username ) ;
	
	
}
