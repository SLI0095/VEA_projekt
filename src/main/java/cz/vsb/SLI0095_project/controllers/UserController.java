package cz.vsb.SLI0095_project.controllers;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/usersMain")
    public String usersMain(Model model){
        model.addAttribute("usersList", userService.getAllUsers());
        return "usersMain";
    }

    @RequestMapping("/newUser")
    public String userNew(Model model){
        model.addAttribute("user", new User());
        return "newUser";
    }

    @RequestMapping("/createUser")
    public String create(@ModelAttribute User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("usersList", userService.getAllUsers());
        return "usersMain";
    }

    @RequestMapping("/editUser")
    public String edit(int id, Model model) {
        User u = userService.getUserById(id);
        if(u != null){
            model.addAttribute("user", u);
            return "editUser";
        }
        else{
            return "index";
        }
    }

    @RequestMapping(value = "/saveUser", params = "action=save")
    public String save(@ModelAttribute User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("usersList", userService.getAllUsers());
        return "usersMain";
    }

    @RequestMapping(value = "/saveUser", params = "action=delete")
    public String delete(@ModelAttribute User user, Model model) {
        userService.deleteUser(user);
        model.addAttribute("usersList", userService.getAllUsers());
        return "usersMain";
    }
}
