package cz.vsb.SLI0095_project.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratingId;

    @OneToOne(mappedBy = "id")
    private User ratingAuthor;
    private LocalDate ratingDate;
    private int numberOfStars;
    @OneToOne(mappedBy = "bookId")
    private Book ratedBook;
    private String comment;
}
