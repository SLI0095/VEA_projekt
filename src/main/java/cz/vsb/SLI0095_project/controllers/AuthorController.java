package cz.vsb.SLI0095_project.controllers;

import cz.vsb.SLI0095_project.entities.Author;
import cz.vsb.SLI0095_project.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping("/authorsMain")
    public String authorMain(Model model){
        model.addAttribute("authorsList", authorService.getAllAuthors());
        return "authorsMain";
    }

    @RequestMapping("/newAuthor")
    public String authorNew(Model model){
        model.addAttribute("author", new Author());
        return "newAuthor";
    }

    @RequestMapping("/createAuthor")
    public String save(@ModelAttribute Author author, Model model) {
        authorService.saveAuthor(author);
        model.addAttribute("authorsList", authorService.getAllAuthors());
        return "authorsMain";
    }
}
