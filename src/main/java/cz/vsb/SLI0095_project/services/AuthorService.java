package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public List<Author> getAllAuthors();
    public void saveAuthor(Author author);
    public Author getAuthorById(long id);
    public void deleteAuthor(Author author);
}
