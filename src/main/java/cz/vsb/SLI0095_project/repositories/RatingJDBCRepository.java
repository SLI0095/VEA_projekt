package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.mappers.BookMapper;
import cz.vsb.SLI0095_project.mappers.RatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RatingJDBCRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Rating> getAllRatings(){
        return jdbcTemplate.query("SELECT * FROM RATING", new RatingMapper());
    }

    public Rating getRatingById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM RATING WHERE RATING_ID = ?", new Object[] { id }, new RatingMapper());
    }

    public List<Rating> getAllRatingsForBook(long bookId){
        return jdbcTemplate.query("SELECT * FROM RATING WHERE RATED_BOOK_BOOK_ID = ?", new Object[ ] { bookId }, new RatingMapper());
    }

    public void saveRating(Rating rating){
        if(rating.getRatingId() > 0) {
            jdbcTemplate.update("UPDATE RATING SET RATING_COMMENT = ?, RATING_SCORE = ?, RATED_BOOK_BOOK_ID = ?, RATING_AUTHOR_PERSON_ID = ? WHERE RATING_ID = ?",
                   rating.getRatingComment(), rating.getRatingScore(), rating.getRatedBook().getBookId(), rating.getRatingAuthor().getPersonId(), rating.getRatingId());
        }
        else {
            jdbcTemplate.update("INSERT INTO RATING(RATING_COMMENT, RATING_SCORE, RATED_BOOK_BOOK_ID, RATING_AUTHOR_PERSON_ID) VALUES(?, ?, ?, ?)",
                    rating.getRatingComment(), rating.getRatingScore(), rating.getRatedBook().getBookId(), rating.getRatingAuthor().getPersonId());
        }

    }

    public void deleteRating(Rating rating){
        jdbcTemplate.update("DELETE FROM RATING WHERE RATING_ID = ?", rating.getRatingId());
    }
}
