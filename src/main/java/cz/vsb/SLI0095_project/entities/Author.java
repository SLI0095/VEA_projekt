package cz.vsb.SLI0095_project.entities;

import com.fasterxml.jackson.annotation.JsonView;
import cz.vsb.SLI0095_project.Views;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue(value = "AUTHOR")
public class Author extends Person{

    @OneToMany(mappedBy = "bookAuthor")
    private List<Book> books;

    @JsonView(Views.Public.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @JsonView(Views.Public.class)
    private String authorInformation;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAuthorInformation() {
        return authorInformation;
    }

    public void setAuthorInformation(String authorInformation) {
        this.authorInformation = authorInformation;
    }

    public Author() {
    }

    public Author(long personId) {
        super(personId);
    }

    public Author(long personId, String name, String surname, List<Book> books, LocalDate dateOfBirth, String authorInformation) {
        super(personId ,name, surname);
        this.books = books;
        this.dateOfBirth = dateOfBirth;
        this.authorInformation = authorInformation;
    }
}
