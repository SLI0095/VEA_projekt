package cz.vsb.SLI0095_project.entities;

import com.fasterxml.jackson.annotation.JsonView;
import cz.vsb.SLI0095_project.Views;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ratingId;

    @JsonView(Views.Public.class)
    @ManyToOne
    private User ratingAuthor;

    @JsonView(Views.Public.class)
    private int ratingScore;

    @JsonView(Views.RatingInfo.class)
    @ManyToOne
    private Book ratedBook;

    @JsonView(Views.Public.class)
    private String ratingComment;

    public Rating() {

    }

    public Rating(long ratingId ,User ratingAuthor, int ratingScore, Book ratedBook, String ratingComment) {
        this.ratingId = ratingId;
        this.ratingAuthor = ratingAuthor;
        this.ratingScore = ratingScore;
        this.ratedBook = ratedBook;
        this.ratingComment = ratingComment;
    }

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }

    public User getRatingAuthor() {
        return ratingAuthor;
    }

    public void setRatingAuthor(User ratingAuthor) {
        this.ratingAuthor = ratingAuthor;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public Book getRatedBook() {
        return ratedBook;
    }

    public void setRatedBook(Book ratedBook) {
        this.ratedBook = ratedBook;
    }

    public String getRatingComment() {
        return ratingComment;
    }

    public void setRatingComment(String ratingComment) {
        this.ratingComment = ratingComment;
    }
}
