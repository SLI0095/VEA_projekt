package cz.vsb.SLI0095_project.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String bookName;

    @OneToOne(mappedBy = "id")
    private Author bookAuthor;

    @OneToMany(mappedBy = "ratingId")
    private List<Rating> ratings;

}
