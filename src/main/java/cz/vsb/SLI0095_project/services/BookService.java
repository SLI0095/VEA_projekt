package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public List<Book> getAllBooks();
    public void saveBook(Book book);
    public Book getBookById(long id);
    public void deleteBook(Book book);
}
