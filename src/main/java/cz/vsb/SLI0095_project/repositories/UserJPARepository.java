package cz.vsb.SLI0095_project.repositories;

import cz.vsb.SLI0095_project.entities.Person;
import cz.vsb.SLI0095_project.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserJPARepository extends CrudRepository<User, Long> {

}
