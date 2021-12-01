package cz.vsb.SLI0095_project.controllers;

import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.services.BookService;
import cz.vsb.SLI0095_project.services.RatingService;
import cz.vsb.SLI0095_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RatingController {

    @Autowired
    RatingService ratingService;
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @RequestMapping("/newRating")
    public String reviewNew(Model model){
        model.addAttribute("rating", new Rating());
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("booksList", bookService.getAllBooks());
        return "newRating";
    }

    @RequestMapping("/createRating")
    public String save(@ModelAttribute Rating rating, Model model) {
        ratingService.saveRating(rating);
        model.addAttribute("booksList", bookService.getAllBooks());
        return "booksMain";
    }
}
