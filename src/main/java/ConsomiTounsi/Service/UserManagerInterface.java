package ConsomiTounsi.Service;

import ConsomiTounsi.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserManagerInterface {
	
    List<User> retrieveAllUser();
    
    //unnecessary 
    /*
    User addUser(User U);
    void deleteUserById(Long id);
    void deleteUserById(String id);
    User updateUser(User U);
    User FindUserById(Long id);
    User FindUserById(String id);*/
    //
    
	User findUserByUsername(String username);
	List<User> findUserByLastNameAndFirstName(String firstname , String lastname);
}
