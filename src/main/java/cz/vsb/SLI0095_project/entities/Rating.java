package cz.vsb.SLI0095_project.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratingId;

    @ManyToOne
    private MyUser ratingAuthor;

    private LocalDate ratingDate;
    private int ratingScore;

    @OneToOne(mappedBy = "bookId")
    private Book ratedBook;

    private String ratingComment;


    public Rating() {

    }

    public Rating(MyUser ratingAuthor, LocalDate ratingDate, int ratingScore, Book ratedBook, String ratingComment) {
        this.ratingAuthor = ratingAuthor;
        this.ratingDate = ratingDate;
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

    public MyUser getRatingAuthor() {
        return ratingAuthor;
    }

    public void setRatingAuthor(MyUser ratingAuthor) {
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

    public String getRatingComment() {
        return ratingComment;
    }

    public void setRatingComment(String ratingComment) {
        this.ratingComment = ratingComment;
    }
}
