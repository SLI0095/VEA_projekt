package cz.vsb.SLI0095_project.controllers;

import cz.vsb.SLI0095_project.repositories.PersonJPARepository;
import cz.vsb.SLI0095_project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping("/personList")
    public String personList(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "personList";
    }
}
