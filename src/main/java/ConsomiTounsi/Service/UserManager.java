package ConsomiTounsi.Service;

import ConsomiTounsi.entities.User;
import ConsomiTounsi.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class UserManager implements UserManagerInterface{
	
	@Autowired
	UserRepository ur ; 
	
    @Override
    public List<User> retrieveAllUser() {
        return (List<User>) ur.findAll();
    }

	@Override
	public User addUser(User U) {
		return ur.save(U);
	}

	@Override
	public void deleteUserById(Long id) {
		 ur.findById(id);
	}

	@Override
	public void deleteUserById(String id) {
		ur.deleteById(Long.parseLong(id));
	}

	@Override
	public User updateUser(User U) {
		return ur.save(U);
	}

	@Override
	public User FindUserById(Long id) {
		return ur.findById(id).orElse(new User());
	}

	@Override
	public User FindUserById(String id) {
		return ur.findById(Long.parseLong(id)).orElse(new User());
	}

	@Override
	public User findUserByUsername(String username) {
		return ur.findByUsernameUser(username);
	}

	@Override
	public List<User> findUserByLastNameAndFirstName(String firstname, String lastname) {
		return ur.findByLastNameUserAndFirstNameUser(firstname, lastname);
	}

}
