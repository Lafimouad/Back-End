package ConsomiTounsi.repository;

import ConsomiTounsi.entities.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository extends CrudRepository<User,Long> {
	
	User findByUsernameUser(String username);
	List<User> findByLastNameUserAndFirstNameUser(String firstname , String lastname);
	
}
