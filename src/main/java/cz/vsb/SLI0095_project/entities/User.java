package cz.vsb.SLI0095_project.entities;

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;

@Entity
public class User extends Person{

    private String login;
    private String password;


}
