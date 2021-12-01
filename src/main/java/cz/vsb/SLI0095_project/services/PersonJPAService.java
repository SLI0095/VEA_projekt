package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.repositories.PersonJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ConditionalOnProperty(
        value="accessType",
        havingValue = "jpa",
        matchIfMissing = true)
public class PersonJPAService implements PersonService{

    @Autowired
    private PersonJPARepository personJPARepository;

    @Override
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        Iterable<Person> iterator = personJPARepository.findAll();
        for(Person p : iterator){
            persons.add(p);
        }
        return persons;
    }
}
