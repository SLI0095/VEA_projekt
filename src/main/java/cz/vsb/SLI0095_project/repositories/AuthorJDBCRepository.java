package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.mappers.AuthorMapper;
import cz.vsb.SLI0095_project.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AuthorJDBCRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Author> getAllAuthors(){
        return jdbcTemplate.query("SELECT * FROM PERSON WHERE PERSON_TYPE='AUTHOR'", new AuthorMapper());
    }

    public Author getAuthorById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE PERSON_ID = ?", new Object[] { id }, new AuthorMapper());
    }

    public void saveAuthor(Author author){
        if(author.getPersonId() > 0) {
            jdbcTemplate.update("UPDATE PERSON SET NAME = ?, SURNAME = ?, AUTHOR_INFORMATION = ?, DATE_OF_BIRTH = ? WHERE PERSON_ID = ?",
                    author.getName(),author.getSurname(), author.getAuthorInformation(), author.getDateOfBirth(), author.getPersonId());
        }
        else {
            jdbcTemplate.update("INSERT INTO PERSON(PERSON_TYPE, NAME, SURNAME, AUTHOR_INFORMATION, DATE_OF_BIRTH) VALUES('AUTHOR', ?, ?, ?, ?)",
                    author.getName(),author.getSurname(), author.getAuthorInformation(), author.getDateOfBirth());
        }

    }

    public void deleteAuthor(Author author){
        jdbcTemplate.update("DELETE FROM PERSON WHERE PERSON_ID = ?", author.getPersonId());
    }
}
