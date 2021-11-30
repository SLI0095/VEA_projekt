package cz.vsb.SLI0095_project.controllers;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.services.AuthorService;
import cz.vsb.SLI0095_project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class bookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/booksMain")
    public String booksMain(Model model){
        model.addAttribute("booksList", bookService.getAllBooks());
        return "booksMain";
    }

    @RequestMapping("/newBook")
    public String bookNew(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("authorsList", authorService.getAllAuthors());
        return "newBook";
    }

    @RequestMapping("/createBook")
    public String save(@ModelAttribute Book book, Model model) {
        bookService.saveBook(book);
        model.addAttribute("booksList", bookService.getAllBooks());
        return "booksMain";
    }

    @RequestMapping("/editBook")
    public String bookNew(int id, Model model){
        Book b = bookService.getBookById(id);
        if(b != null){
            model.addAttribute("book", b);
            model.addAttribute("authorsList", authorService.getAllAuthors());
            return "editBook";
        }
        else {
            return "index";
        }
    }

    @RequestMapping("/bookRatings")
    public String bookRatings(int id, Model model) {
        Book b = bookService.getBookById(id);
        if(b != null) {
            model.addAttribute("book", b);
            return "bookRatings";
        }
        else {
            return "index";
        }
    }

    @RequestMapping(value = "/saveBook", params = "action=save")
    public String edit(@ModelAttribute Book book, Model model) {
        bookService.saveBook(book);
        model.addAttribute("booksList", bookService.getAllBooks());
        return "booksMain";
    }

    @RequestMapping(value = "/saveBook", params = "action=delete")
    public String delete(@ModelAttribute Book book, Model model) {
        bookService.deleteBook(book);
        model.addAttribute("booksList", bookService.getAllBooks());
        return "booksMain";
    }
}
