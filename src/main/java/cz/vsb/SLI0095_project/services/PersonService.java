package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.repositories.PersonJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonJPARepository personRepository;

    public List<Person> getAllPersons(){
        return personRepository.getAllPersons();
    }

    public void savePerson(Person person){
        personRepository.savePerson(person);
    }
}
