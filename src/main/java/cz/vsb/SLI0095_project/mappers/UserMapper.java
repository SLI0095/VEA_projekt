package cz.vsb.SLI0095_project.mappers;

import cz.vsb.SLI0095_project.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;


public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getInt("PERSON_ID"),
                rs.getString("NAME"),
                rs.getString("SURNAME"),
                rs.getString("LOGIN"),
                rs.getString("PASSWORD"),
                Collections.emptyList()
        );
    }
}
