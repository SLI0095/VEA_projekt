package cz.vsb.SLI0095_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import cz.vsb.SLI0095_project.Views;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import java.util.List;

@Entity
@DiscriminatorValue(value = "USER")
public class User extends Person{

    @JsonView(Views.Public.class)
    private String login;

    private String password;

    @JsonView(Views.UserInfo.class)
    @OneToMany(mappedBy = "ratingAuthor")
    private List<Rating> usersRatings;


    public User() {

    }

    public User(long personId) {
        super(personId);
    }

    public User(long personId, String name, String surname, String login, String password, List<Rating> usersRatings) {
        super(personId, name, surname);
        this.login = login;
        this.password = password;
        this.usersRatings = usersRatings;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rating> getUsersRatings() {
        return usersRatings;
    }

    public void setUsersRatings(List<Rating> usersRatings) {
        this.usersRatings = usersRatings;
    }
}
