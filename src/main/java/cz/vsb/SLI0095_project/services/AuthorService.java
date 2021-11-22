package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.repositories.AuthorJPARepository;
import cz.vsb.SLI0095_project.repositories.PersonJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorJPARepository authorJPARepository;

    public List<Person> getAllAuthors(){
        List<Person> authors = new ArrayList<>();
        Iterable<Person> iterator = authorJPARepository.findAll();
        for(Person p : iterator){
            authors.add(p);
        }
        return authors;
    }

    @Transactional
    public void saveAuthor(Author author){
        if(author.getId() == 0){
           authorJPARepository.save(author);
        }
        else if (author.getId() > 0){
            if(authorJPARepository.existsById(author.getId())){
                authorJPARepository.save(author);
            }
        }
    }

    public Person getAuthorById(long id){
        Optional<Person> authorData = authorJPARepository.findById(id);
        if(authorData.isPresent())
        {
            return authorData.get();
        }
        else return null;
    }

    /*
    public void init(){
        Author a = new Author("John", "Doe", Collections.emptyList(), LocalDate.of(1976,10,9) , "Blah blah");
        authorJPARepository.save(a);
    }
     */


}
