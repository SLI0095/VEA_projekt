package cz.vsb.SLI0095_project.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import cz.vsb.SLI0095_project.Views;
import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.services.AuthorService;
import cz.vsb.SLI0095_project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRESTController {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;


    @JsonView(Views.BookInfo.class)
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("book")
    public void saveBook(@RequestBody Book book) {
        Author a = authorService.getAuthorById(book.getBookAuthor().getPersonId());
        book.setBookAuthor(a);
        bookService.saveBook(book);
    }

}
