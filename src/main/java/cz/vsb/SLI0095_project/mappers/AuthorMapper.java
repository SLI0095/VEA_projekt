package cz.vsb.SLI0095_project.mappers;

import cz.vsb.SLI0095_project.entities.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Author(
                rs.getInt("PERSON_ID"),
                rs.getString("NAME"),
                rs.getString("SURNAME"),
                Collections.emptyList(),
                rs.getDate("DATE_OF_BIRTH").toLocalDate(),
                rs.getString("AUTHOR_INFORMATION")
        );
    }
}
