package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.repositories.UserJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(
        value="accessType",
        havingValue = "jdbc",
        matchIfMissing = false)
public class UserJDBCService implements UserService{

    @Autowired
    UserJDBCRepository userJDBCRepository;

    @Override
    public List<User> getAllUsers() {
       List<User> users = userJDBCRepository.getAllUsers();
       return users;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUserById(long id) {
        User user = userJDBCRepository.getUserById(id);
        return user;
    }

    @Override
    public void deleteUser(User user) {

    }
}
