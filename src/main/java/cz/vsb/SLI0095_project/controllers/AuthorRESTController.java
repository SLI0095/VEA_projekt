package cz.vsb.SLI0095_project.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import cz.vsb.SLI0095_project.Views;
import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class AuthorRESTController {

    @Autowired
    AuthorService authorService;

    @JsonView(Views.AuthorInfo.class)
    @GetMapping("/authors")
    List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping("/authors")
    public void saveAuthor(@RequestBody Author author){
        if(author.getPersonId() > 0){
            authorService.saveAuthor(author);
        }else {
            author.setBooks(Collections.emptyList());
            authorService.saveAuthor(author);
        }
    }
}
