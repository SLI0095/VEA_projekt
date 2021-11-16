package cz.vsb.SLI0095_project.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue(value = "AUTHOR")
public class Author extends Person{

    @OneToMany(mappedBy = "bookId")
    private List<Book> books;
    private LocalDate dateOfBirth;
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

    public Author(String name, String surname, List<Book> books, LocalDate dateOfBirth, String authorInformation) {
        super(name, surname);
        this.books = books;
        this.dateOfBirth = dateOfBirth;
        this.authorInformation = authorInformation;
    }
}
