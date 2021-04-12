package ConsomiTounsi.Service;

import ConsomiTounsi.entities.User;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

public interface UserManagerInterface {
    List<User> retrieveAllUser();
    User addUser(User U);
    void deleteUser(Long id);
    void User(String id);
    User updateUser(User U);
    Optional<User> FindUser(Long id);
    Optional<User> FindUser(String id);
    
}
