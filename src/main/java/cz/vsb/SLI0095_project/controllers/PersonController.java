package cz.vsb.SLI0095_project.controllers;

import cz.vsb.SLI0095_project.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @Autowired
    private AuthorService personService;


    @RequestMapping("/personList")
    public String personList(Model model) {
        return "personList";
    }
}
