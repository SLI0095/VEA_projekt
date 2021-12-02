package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.repositories.PersonJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(
        value="accessType",
        havingValue = "jdbc",
        matchIfMissing = false)
public class PersonJDBCService implements PersonService{

    @Autowired
    PersonJDBCRepository personJDBCRepository;

    @Override
    public List<Person> getAllPersons() {
        return personJDBCRepository.getAllPersons();
    }
}
