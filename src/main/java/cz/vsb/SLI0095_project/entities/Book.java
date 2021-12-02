package cz.vsb.SLI0095_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import cz.vsb.SLI0095_project.Views;

@Entity
public class Book {

    @JsonView(Views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    @JsonView(Views.Public.class)
    private String bookName;

    @JsonView(Views.RatingInfo.class)
    @ManyToOne
    private Author bookAuthor;


    @JsonView(Views.BookInfo.class)
    @OneToMany(mappedBy = "ratedBook")
    private List<Rating> ratings;

    @JsonView(Views.Public.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseDate;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Book() {

    }

    public Book(long bookId) {
        this.bookId = bookId;
    }

    public Book(long bookId, String bookName, Author bookAuthor, List<Rating> ratings, LocalDate releaseDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.ratings = ratings;
        this.releaseDate = releaseDate;
    }


}
