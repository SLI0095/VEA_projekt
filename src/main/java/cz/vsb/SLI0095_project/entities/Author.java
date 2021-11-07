package cz.vsb.SLI0095_project.entities;

import javax.persistence.Entity;

@Entity
public class Author extends Person{

    private Book bestSeller;

    public Author(long id, String name, String surname) {
        super(id, name, surname);
    }
}
