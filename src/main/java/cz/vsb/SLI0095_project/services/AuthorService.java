package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.repositories.AuthorJPARepository;
import cz.vsb.SLI0095_project.repositories.PersonJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorJPARepository authorJPARepository;

    public void init(){
        Author a = new Author("John", "Doe", Collections.emptyList(), LocalDate.of(1976,10,9) , "Blah blah");
        authorJPARepository.save(a);
    }


}
