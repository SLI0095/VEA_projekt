package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PersonJDBCRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Person> getAllPersons(){
        return jdbcTemplate.query("SELECT * FROM PERSON", new PersonMapper());
    }
}
