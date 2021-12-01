package cz.vsb.SLI0095_project.entities;

import com.fasterxml.jackson.annotation.JsonView;
import cz.vsb.SLI0095_project.Views;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "PERSON_TYPE",
        discriminatorType = DiscriminatorType.STRING
)
public class Person {

    @JsonView(Views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private String surname;


    public Person() {

    }

    public Person(long personId) {
        this.personId = personId;
    }

    public Person(long personId, String name, String surname) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
