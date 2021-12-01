package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.repositories.AuthorJDBCRepository;
import cz.vsb.SLI0095_project.repositories.BookJDBCRepository;
import cz.vsb.SLI0095_project.repositories.RatingJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(
        value="accessType",
        havingValue = "jdbc",
        matchIfMissing = false)
public class AuthorJDBCService implements AuthorService{

    @Autowired
    AuthorJDBCRepository authorJDBCRepository;
    @Autowired
    BookJDBCRepository bookJDBCRepository;
    @Autowired
    RatingJDBCRepository ratingJDBCRepository;

    @Override
    public List<Author> getAllAuthors() {
        List<Author> authors = authorJDBCRepository.getAllAuthors();
        for(Author author : authors)
        {
            List<Book> authorsBooks = bookJDBCRepository.getBooksFromAuthor(author.getPersonId());
            for(Book b : authorsBooks)
            {
                b.setBookAuthor(author);
            }
            author.setBooks(authorsBooks);
        }
        return authors;
    }

    @Override
    public void saveAuthor(Author author) {
        authorJDBCRepository.saveAuthor(author);
    }

    @Override
    public Author getAuthorById(long id) {
        Author author = authorJDBCRepository.getAuthorById(id);
        List<Book> authorsBooks = bookJDBCRepository.getBooksFromAuthor(author.getPersonId());
        for(Book b : authorsBooks)
        {
            b.setBookAuthor(author);
        }
        author.setBooks(authorsBooks);
        return author;
    }

    @Override
    public void deleteAuthor(Author author) {
        for(Book book : author.getBooks()) {
            for(Rating rating : book.getRatings()) {
                ratingJDBCRepository.deleteRating(rating);
            }
            bookJDBCRepository.deleteBook(book);
        }
        authorJDBCRepository.deleteAuthor(author);
    }
}
