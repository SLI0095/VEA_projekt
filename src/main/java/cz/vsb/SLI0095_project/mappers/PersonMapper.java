package cz.vsb.SLI0095_project.mappers;

import cz.vsb.SLI0095_project.entities.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                rs.getInt("PERSON_ID"),
                rs.getString("NAME"),
                rs.getString("SURNAME")
        );
    }
}
