package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.repositories.RatingJPARepository;
import cz.vsb.SLI0095_project.repositories.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ConditionalOnProperty(
        value="accessType",
        havingValue = "jpa",
        matchIfMissing = true)
public class UserJPAService implements UserService {

    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private RatingJPARepository ratingJPARepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        Iterable<User> iterator = userJPARepository.findAll();
        for(User u : iterator){
            users.add(u);
        }
        return users;
    }

    @Transactional
    public void saveUser(User user){
        if(user.getPersonId() == 0){
            userJPARepository.save(user);
        }
        else if (user.getPersonId() > 0){
            if(userJPARepository.existsById(user.getPersonId())){
                userJPARepository.save(user);
            }
        }
    }

    public User getUserById(long id){
        Optional<User> userData = userJPARepository.findById(id);
        if(userData.isPresent())
        {
            return userData.get();
        }
        else return null;
    }

    @Transactional
    public void deleteUser(User user) {
        for(Rating rating : user.getUsersRatings()){
            ratingJPARepository.delete(rating);
        }
        userJPARepository.delete(user);
    }
}
