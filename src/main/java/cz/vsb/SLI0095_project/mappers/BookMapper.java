package cz.vsb.SLI0095_project.mappers;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
                rs.getInt("BOOK_ID"),
                rs.getString("BOOK_NAME"),
                new Author(rs.getInt("BOOK_AUTHOR_PERSON_ID")),
                Collections.emptyList(),
                rs.getDate("RELEASE_DATE").toLocalDate()
        );
    }
}
