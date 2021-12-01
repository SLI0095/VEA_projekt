package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUserById(long id);
    public void deleteUser(User user);
}
