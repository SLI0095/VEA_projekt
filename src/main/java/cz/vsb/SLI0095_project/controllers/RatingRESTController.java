package cz.vsb.SLI0095_project.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import cz.vsb.SLI0095_project.Views;
import cz.vsb.SLI0095_project.entities.Book;
import cz.vsb.SLI0095_project.entities.Rating;
import cz.vsb.SLI0095_project.entities.User;
import cz.vsb.SLI0095_project.services.BookService;
import cz.vsb.SLI0095_project.services.RatingService;
import cz.vsb.SLI0095_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingRESTController {

    @Autowired
    RatingService ratingService;
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @JsonView(Views.RatingInfo.class)
    @GetMapping("/ratings")
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

    @PostMapping("/ratings")
    public void addRating(@RequestBody Rating rating){
        User ratingUser = userService.getUserById(rating.getRatingAuthor().getPersonId());
        Book book = bookService.getBookById(rating.getRatedBook().getBookId());
        Rating ratingFinal = rating;
        if(ratingFinal.getRatingScore() > 10){
            ratingFinal.setRatingScore(10);
        }else if(ratingFinal.getRatingScore() < 0){
            ratingFinal.setRatingScore(0);
        }
        ratingFinal.setRatingAuthor(ratingUser);
        ratingFinal.setRatedBook(book);
        ratingService.saveRating(ratingFinal);
    }
}
