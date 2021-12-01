package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.repositories.AuthorJDBCRepository;
import cz.vsb.SLI0095_project.repositories.BookJDBCRepository;
import cz.vsb.SLI0095_project.repositories.RatingJDBCRepository;
import cz.vsb.SLI0095_project.repositories.UserJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(
        value="accessType",
        havingValue = "jdbc",
        matchIfMissing = false)
public class BookJDBCService implements BookService{

    @Autowired
    BookJDBCRepository bookJDBCRepository;
    @Autowired
    AuthorJDBCRepository authorJDBCRepository;
    @Autowired
    RatingJDBCRepository ratingJDBCRepository;
    @Autowired
    UserJDBCRepository userJDBCRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookJDBCRepository.getAllBooks();
        for(Book book : books)
        {
            Author a = authorJDBCRepository.getAuthorById(book.getBookAuthor().getPersonId());
            book.setBookAuthor(a);
            List<Rating> bookRatings = ratingJDBCRepository.getAllRatingsForBook(book.getBookId());
            for(Rating r : bookRatings){
                r.setRatedBook(book);
                User user = userJDBCRepository.getUserById(r.getRatingAuthor().getPersonId());
                r.setRatingAuthor(user);
            }
            book.setRatings(bookRatings);
        }
        return books;
    }

    @Override
    public void saveBook(Book book) {
        bookJDBCRepository.saveBook(book);
    }

    @Override
    public Book getBookById(long id) {
        Book book = bookJDBCRepository.getBookById(id);
        Author a = authorJDBCRepository.getAuthorById(book.getBookAuthor().getPersonId());
        book.setBookAuthor(a);
        List<Rating> bookRatings = ratingJDBCRepository.getAllRatingsForBook(book.getBookId());
        for(Rating r : bookRatings){
            r.setRatedBook(book);
            User user = userJDBCRepository.getUserById(r.getRatingAuthor().getPersonId());
            r.setRatingAuthor(user);
        }
        book.setRatings(bookRatings);
        return book;
    }

    @Override
    public void deleteBook(Book book) {
        for(Rating rating : book.getRatings()) {
            ratingJDBCRepository.deleteRating(rating);
        }
        bookJDBCRepository.deleteBook(book);
    }
}
