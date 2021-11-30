package cz.vsb.SLI0095_project.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "PERSON_TYPE",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;
    private String name;
    private String surname;


    public Person() {

    }

    public Person(String name, String surname) {
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
