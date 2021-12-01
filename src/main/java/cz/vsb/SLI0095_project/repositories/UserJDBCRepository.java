package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserJDBCRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getAllUsers(){
        return jdbcTemplate.query("SELECT * from PERSON WHERE PERSON_TYPE='USER'", new UserMapper());
    }

    public User getUserById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE PERSON_ID = ?", new Object[] { id }, new UserMapper());
    }

    public void saveUser(User user){
        if(user.getPersonId() > 0) {
            jdbcTemplate.update("UPDATE PERSON SET NAME = ?, SURNAME = ?, LOGIN = ?, PASSWORD = ? WHERE PERSON_ID = ?",
                    user.getName(),user.getSurname(), user.getLogin(), user.getPassword(), user.getPersonId());
        }
        else {
            jdbcTemplate.update("INSERT INTO PERSON(PERSON_TYPE, NAME, SURNAME, LOGIN, PASSWORD) VALUES('AUTHOR', ?, ?, ?, ?)",
                    user.getName(),user.getSurname(), user.getLogin(), user.getPassword());
        }

    }

    public void deleteUser(User user){
        jdbcTemplate.update("DELETE FROM PERSON WHERE PERSON_ID = ?", user.getPersonId());
    }

}
