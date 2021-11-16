package cz.vsb.SLI0095_project.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratingId;

    @ManyToOne
    private User ratingAuthor;

    private LocalDate ratingDate;
    private int ratingScore;

    @OneToOne(mappedBy = "bookId")
    private Book ratedBook;

    private String comment;


    public Rating() {

    }

    public Rating(User ratingAuthor, LocalDate ratingDate, int ratingScore, Book ratedBook, String comment) {
        this.ratingAuthor = ratingAuthor;
        this.ratingDate = ratingDate;
        this.ratingScore = ratingScore;
        this.ratedBook = ratedBook;
        this.comment = comment;
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

    public LocalDate getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDate ratingDate) {
        this.ratingDate = ratingDate;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
