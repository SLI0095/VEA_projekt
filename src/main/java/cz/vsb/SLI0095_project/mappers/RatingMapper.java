package cz.vsb.SLI0095_project.mappers;

import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingMapper implements RowMapper<Rating> {
    @Override
    public Rating mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Rating(
                rs.getInt("RATING_ID"),
                new User(rs.getInt("RATING_AUTHOR_PERSON_ID")),
                rs.getInt("RATING_SCORE"),
                new Book(rs.getInt("RATED_BOOK_BOOK_ID")),
                rs.getString("RATING_COMMENT")
        );
    }
}
