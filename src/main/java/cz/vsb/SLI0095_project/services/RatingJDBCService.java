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
public class RatingJDBCService implements RatingService{

    @Autowired
    BookJDBCRepository bookJDBCRepository;
    @Autowired
    AuthorJDBCRepository authorJDBCRepository;
    @Autowired
    RatingJDBCRepository ratingJDBCRepository;
    @Autowired
    UserJDBCRepository userJDBCRepository;

    @Override
    public void saveRating(Rating rating) {
        ratingJDBCRepository.saveRating(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating> ratings = ratingJDBCRepository.getAllRatings();
        for(Rating rating : ratings) {
            Book book = bookJDBCRepository.getBookById(rating.getRatedBook().getBookId());
            Author author = authorJDBCRepository.getAuthorById(book.getBookAuthor().getPersonId());
            book.setBookAuthor(author);
            rating.setRatedBook(book);
            User user = userJDBCRepository.getUserById(rating.getRatingAuthor().getPersonId());
            rating.setRatingAuthor(user);
        }
        return ratings;
    }

    @Override
    public Rating getRatingById(long id) {
        return ratingJDBCRepository.getRatingById(id);
    }

    @Override
    public void deleteRating(Rating rating) {
        ratingJDBCRepository.deleteRating(rating);
    }
}
