package cz.vsb.SLI0095_project.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import cz.vsb.SLI0095_project.Views;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RestController
public class UserRESTController {

    @Autowired
    UserService userService;

    @JsonView(Views.UserInfo.class)
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public void registerNewUser(@RequestBody User user) {
        if(user.getPersonId() <= 0)
        {
            user.setUsersRatings(Collections.emptyList());
            userService.saveUser(user);
        }
    }
}
