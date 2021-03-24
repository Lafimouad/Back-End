package ConsomiTounsi.repository;

import ConsomiTounsi.entities.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	User findByUsernameUser(String username);
	
	
}
