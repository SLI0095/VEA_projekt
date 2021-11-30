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

    public List<Author> getAllAuthors(){
        List<Author> authors = new ArrayList<>();
        Iterable<Author> iterator = authorJPARepository.findAll();
        for(Author a : iterator){
            authors.add(a);
        }
        return authors;
    }

    @Transactional
    public void saveAuthor(Author author){
        if(author.getPersonId() == 0){
           authorJPARepository.save(author);
        }
        else if (author.getPersonId() > 0){
            if(authorJPARepository.existsById(author.getPersonId())){
                authorJPARepository.save(author);
            }
        }
    }

    public Author getAuthorById(long id){
        Optional<Author> authorData = authorJPARepository.findById(id);
        if(authorData.isPresent())
        {
            return authorData.get();
        }
        else return null;
    }

    public void deleteAuthor(Author author){
        authorJPARepository.delete(author);
    }

    /*
    public void init(){
        Author a = new Author("John", "Doe", Collections.emptyList(), LocalDate.of(1976,10,9) , "Blah blah");
        authorJPARepository.save(a);
    }
     */


}
