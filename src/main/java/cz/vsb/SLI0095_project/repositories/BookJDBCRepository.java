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
        return jdbcTemplate.query("SELECT * FROM BOOK WHERE BOOK_AUTHOR_PERSON_ID = ?", new Object[] { authorId}, new BookMapper());
    }

    public void saveBook(Book book){
        if(book.getBookId() > 0) {
            jdbcTemplate.update("UPDATE BOOK SET BOOK_NAME = ?, RELEASE_DATE = ?, BOOK_AUTHOR_PERSON_ID = ? WHERE BOOK_ID = ?",
                    book.getBookName(), book.getReleaseDate(),book.getBookAuthor().getPersonId(),book.getBookId());
        }
        else {
            jdbcTemplate.update("INSERT INTO BOOK(BOOK_NAME, RELEASE_DATE, BOOK_AUTHOR_PERSON_ID) VALUES(?, ?, ?)",
                    book.getBookName(),book.getReleaseDate(),book.getBookAuthor().getPersonId());
        }

    }

    public void deleteBook(Book book){
        jdbcTemplate.update("DELETE FROM BOOK WHERE BOOK_ID = ?", book.getBookId());
    }
}
