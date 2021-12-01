package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.repositories.AuthorJPARepository;
import cz.vsb.SLI0095_project.repositories.BookJPARepository;
import cz.vsb.SLI0095_project.repositories.PersonJPARepository;
import cz.vsb.SLI0095_project.repositories.RatingJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@ConditionalOnProperty(
        value="accessType",
        havingValue = "jpa",
        matchIfMissing = true)
public class AuthorJPAService implements AuthorService{

    @Autowired
    private AuthorJPARepository authorJPARepository;
    @Autowired
    private BookJPARepository bookJPARepository;
    @Autowired
    private RatingJPARepository ratingJPARepository;

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

    @Transactional
    public void deleteAuthor(Author author){
        for (Book book : author.getBooks()) {
            for(Rating rating : book.getRatings()){
                ratingJPARepository.delete(rating);
            }
            bookJPARepository.delete(book);
        }
        authorJPARepository.delete(author);
    }
}
