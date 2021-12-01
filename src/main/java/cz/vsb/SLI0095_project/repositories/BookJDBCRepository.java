package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.mappers.BookMapper;
import cz.vsb.SLI0095_project.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookJDBCRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Book> getAllBooks(){
        return jdbcTemplate.query("SELECT * FROM BOOK", new BookMapper());
    }

    public Book getBookById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM BOOK WHERE BOOK_ID = ?", new Object[] { id }, new BookMapper());
    }

    public List<Book> getBooksFromAuthor(long authorId){
        return jdbcTemplate.query("SELECT * FROM BOOK WHERE RATING_AUTHOR_PERSON_ID = ?", new Object[ ] { authorId}, new BookMapper());
    }
}
