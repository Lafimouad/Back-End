package ConsomiTounsi.Service;

import ConsomiTounsi.entities.User;

import java.util.List;
import java.util.Optional;

public class UserManager implements UserManagerInterface{
    @Override
    public List<User> retrieveAllUser() {
        return null;
    }

    @Override
    public User addUser(User U) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void User(String id) {

    }

    @Override
    public User updateUser(User U) {
        return null;
    }

    @Override
    public Optional<User> FindUser(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> FindUser(String id) {
        return Optional.empty();
    }
}
