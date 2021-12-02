package cz.vsb.SLI0095_project.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import cz.vsb.SLI0095_project.Views;
import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRESTController {

    @Autowired
    PersonService personService;

    @JsonView(Views.Public.class)
    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }
}
