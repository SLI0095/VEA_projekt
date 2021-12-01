package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    public List<Person> getAllPersons();
}
